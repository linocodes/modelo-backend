package br.gov.mg.meioambiente.controller;

import java.io.Serializable;
import java.util.List;
import java.util.Optional;

import javax.persistence.EntityNotFoundException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.validation.ConstraintViolationException;
import javax.validation.Valid;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.web.PageableDefault;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.Errors;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseStatus;
import br.gov.mg.meioambiente.exception.AppException;
import br.gov.mg.meioambiente.exception.NotFoundException;
import br.gov.mg.meioambiente.persistence.service.AbstractService;

public abstract class BaseRestController<T, PK extends Serializable> extends AbstractRestHandler {

	private AbstractService<T, PK> service;

	public BaseRestController(AbstractService<T, PK> service) {
		this.service = service;
	}

	@PostMapping(value = "")
	public ResponseEntity<?> createEntity(@RequestBody @Valid T entity, Errors errors, HttpServletRequest request, HttpServletResponse response) {
		T registro = this.service.createEntity(entity);
		return new ResponseEntity<>(registro, HttpStatus.CREATED);
	}

	@PutMapping(value = "{id}")
	public ResponseEntity<?> updateEntity(@RequestBody @Valid T entity, @PathVariable("id") PK id, Errors errors, HttpServletRequest request, HttpServletResponse response) {
		T registro = this.service.update(entity, id);
		return new ResponseEntity<>(registro, HttpStatus.ACCEPTED);
	}

	@DeleteMapping(value = "{id}")
	public ResponseEntity<?> deleteEntityId(@PathVariable("id") PK id, HttpServletRequest request, HttpServletResponse response) throws AppException {
		this.service.deleteById(id);
		return new ResponseEntity<Void>(HttpStatus.NO_CONTENT);
	}

	@GetMapping(value = "{id}")
	public ResponseEntity<?> getEntity(@PathVariable PK id)  {
		Optional<T> entity = this.service.getById(id);
		return new ResponseEntity<>(entity, HttpStatus.FOUND);
	}

	@GetMapping(value = "")
	public ResponseEntity<List<T>> getAll() throws NotFoundException {
		return new ResponseEntity<List<T>>(this.service.getAll(), HttpStatus.OK);
	}

	@GetMapping(value = "listar")
	public ResponseEntity<List<T>> getListar() throws NotFoundException {
		return new ResponseEntity<List<T>>(this.service.getAll(), HttpStatus.OK);
	}

	/*
	 * 
	 * @RequestMapping(value = "/{id}", method = RequestMethod.GET, produces = {
	 * "application/json", "application/xml" })
	 * 
	 * @ResponseStatus(HttpStatus.OK)
	 * public ResponseEntity<?> getById(@PathVariable("id") PK id,
	 * HttpServletRequest request, HttpServletResponse response) throws AppException
	 * {
	 * T registro = this.service.getById(id);
	 * checkResourceFound(registro);
	 * return new ResponseEntity<T>(registro, HttpStatus.OK);
	 * }
	 * 
	 * @RequestMapping(value = "/{id}", method = RequestMethod.PUT, consumes = {
	 * "application/json", "application/xml" }, produces = { "application/json",
	 * "application/xml" })
	 * 
	 * @ResponseStatus(HttpStatus.NO_CONTENT)
	 * public ResponseEntity<?> update(@PathVariable("id") PK
	 * id, @Valid @RequestBody T entity, Errors errors, HttpServletRequest request,
	 * HttpServletResponse response) throws AppException {
	 * 
	 * if (errors.hasErrors()) {
	 * // throw new
	 * //
	 * ParametrosInvalidosExceptionSade(MensagensErro.getAtributosInvalidos(errors))
	 * ;
	 * }
	 * 
	 * // checkResourceFound(this.service.getById(id));
	 * 
	 * // if (!((BaseEntity<T>) entity).getId().equals(id)) {
	 * // throw new ParametrosInvalidosExceptionSade("id");
	 * // }
	 * 
	 * T registro = this.service.update(entity);
	 * return new ResponseEntity<T>(registro, HttpStatus.OK);
	 * }
	 * 
	 * @RequestMapping(value = "deleteID/{id}", method = RequestMethod.DELETE)
	 * public ResponseEntity<Void> deleteById(@PathVariable("id") PK id,
	 * HttpServletRequest request, HttpServletResponse response) throws AppException
	 * {
	 * this.service.deleteById(id);
	 * return new ResponseEntity<Void>(HttpStatus.OK);
	 * }
	 * 
	 * @RequestMapping(value = "/{id}", method = RequestMethod.DELETE)
	 * public ResponseEntity<Void> delete(@RequestBody T entity, HttpServletRequest
	 * request, HttpServletResponse response) throws AppException {
	 * this.service.delete(entity);
	 * return new ResponseEntity<Void>(HttpStatus.OK);
	 * }
	 * 
	 * @RequestMapping(value = "/list", method = RequestMethod.GET, produces = {
	 * "application/json", "application/xml" })
	 * 
	 * @ResponseStatus(HttpStatus.OK)
	 * public ResponseEntity<Page<T>> getPageAll(
	 * 
	 * @PageableDefault(value = 10, page = 0) Pageable pageable, @RequestParam(value
	 * = "search") String search, HttpServletRequest request, HttpServletResponse
	 * response) throws AppException {
	 * 
	 * Page<T> page = null;
	 * 
	 * if (search.isEmpty()) {
	 * page = this.service.getAll(pageable);
	 * } else {
	 * page = this.service.getByFilter(search, pageable);
	 * }
	 * 
	 * return new ResponseEntity<Page<T>>(page, HttpStatus.OK);
	 * }
	 * 
	 * @RequestMapping(value = "/listfilter", method = RequestMethod.GET, produces =
	 * { "application/json", "application/xml" })
	 * 
	 * @ResponseStatus(HttpStatus.OK)
	 * public ResponseEntity<List<T>> getAll(HttpServletRequest request,
	 * HttpServletResponse response) {
	 * return null;
	 * // return new ResponseEntity<List<T>>(this.service.getByFilter(spec,
	 * pageable)
	 * // getAll(), HttpStatus.OK);
	 * }
	 */

}