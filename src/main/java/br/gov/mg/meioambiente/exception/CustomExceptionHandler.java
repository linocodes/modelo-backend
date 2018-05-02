package br.gov.mg.meioambiente.exception;

import static org.springframework.http.HttpStatus.BAD_REQUEST;
import static org.springframework.http.HttpStatus.NOT_FOUND;

import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import javax.validation.ConstraintViolation;
import javax.validation.ConstraintViolationException;

import org.hibernate.exception.DataException;
import org.postgresql.util.PSQLException;
import org.springframework.beans.TypeMismatchException;
import org.springframework.core.Ordered;
import org.springframework.core.annotation.Order;
import org.springframework.dao.DataAccessException;
import org.springframework.dao.DataIntegrityViolationException;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.validation.BindException;
import org.springframework.validation.FieldError;
import org.springframework.validation.ObjectError;
import org.springframework.web.HttpMediaTypeNotSupportedException;
import org.springframework.web.HttpRequestMethodNotSupportedException;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.MissingServletRequestParameterException;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.context.request.WebRequest;
import org.springframework.web.method.annotation.MethodArgumentTypeMismatchException;
import org.springframework.web.multipart.support.MissingServletRequestPartException;
import org.springframework.web.servlet.NoHandlerFoundException;
import org.springframework.web.servlet.mvc.method.annotation.ResponseEntityExceptionHandler;

import lombok.extern.slf4j.Slf4j;

@Order(Ordered.HIGHEST_PRECEDENCE)
@ControllerAdvice
@Slf4j
public class CustomExceptionHandler extends ResponseEntityExceptionHandler {

	/*
	 * @ExceptionHandler(javax.validation.ConstraintViolationException.class)
	 * public ResponseEntity<Object> handleConstraintViolation(final
	 * javax.validation.ConstraintViolationException ex, final WebRequest request) {
	 * ApiError apiError = new ApiError(BAD_REQUEST);
	 * apiError.setMessage("Validation error");
	 * apiError.addValidationErrors(ex.getConstraintViolations());
	 * return buildResponseEntity(apiError);
	 * 
	 * }
	 */

	@ExceptionHandler(javax.validation.ConstraintViolationException.class)
	protected ResponseEntity<Object> handleConstraintViolation(javax.validation.ConstraintViolationException ex) {
		ApiError apiError = new ApiError(BAD_REQUEST);
		apiError.setMessage("Validation error");
		apiError.addValidationErrors(ex.getConstraintViolations());
		return buildResponseEntity(apiError);
	}

	@ExceptionHandler(MethodArgumentTypeMismatchException.class)
	protected ResponseEntity<Object> handleMethodArgumentTypeMismatch(MethodArgumentTypeMismatchException ex, WebRequest request) {
		ApiError apiError = new ApiError(BAD_REQUEST);
		apiError.setMessage(String.format("The parameter '%s' of value '%s' could not be converted to type '%s'", ex.getName(), ex.getValue(), ex.getRequiredType().getSimpleName()));
		apiError.setDebugMessage(ex.getMessage());
		return buildResponseEntity(apiError);
	}

	@ExceptionHandler(DataIntegrityViolationException.class)
	protected ResponseEntity<Object> handleDataIntegrityViolation(DataIntegrityViolationException ex, WebRequest request) {
		
		Throwable mostSpecificCause = ex.getMostSpecificCause();
		
		if (mostSpecificCause.getCause() instanceof PSQLException) {
			return buildResponseEntity(new ApiError(HttpStatus.INTERNAL_SERVER_ERROR, "Database error", mostSpecificCause.getCause()));			
		}
		
		if (ex.getCause() instanceof DataException) {
			return buildResponseEntity(new ApiError(HttpStatus.CONFLICT, "Database error", mostSpecificCause));
		}

		if (ex.getCause() instanceof ConstraintViolationException) {
			return buildResponseEntity(new ApiError(HttpStatus.CONFLICT, "Database error", ex.getCause()));
		}
		return buildResponseEntity(new ApiError(HttpStatus.INTERNAL_SERVER_ERROR, ex));
	}

	// Specify name of a specific view that will be used to display the error:
	@ExceptionHandler({ SQLException.class, DataAccessException.class })
	public String databaseError() {
		// Nothing to do. Returns the logical view name of an error page, passed
		// to the view-resolver(s) in usual way.
		// Note that the exception is NOT available to this view (it is not added
		// to the model) but see "Extending ExceptionHandlerExceptionResolver"
		// below.
		return "databaseError";
	}

	@ExceptionHandler(NotFoundException.class)
	protected ResponseEntity<Object> handleEntityNotFound(NotFoundException ex) {
		ApiError apiError = new ApiError(NOT_FOUND);
		apiError.setMessage(ex.getMessage());
		return buildResponseEntity(apiError);
	}


	// 500

	@ExceptionHandler({ Exception.class })
	public ResponseEntity<Object> handleAll(final Exception ex, final WebRequest request) {
		logger.info(ex.getClass().getName());
		logger.error("error", ex);
		//
		final ApiError apiError = new ApiError(HttpStatus.INTERNAL_SERVER_ERROR, "error occurred", ex);
		return new ResponseEntity<Object>(apiError, new HttpHeaders(), apiError.getStatus());
	}

	private ResponseEntity<Object> buildResponseEntity(ApiError apiError) {
		return new ResponseEntity<>(apiError, apiError.getStatus());
	}

}