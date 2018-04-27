package br.gov.mg.meioambiente.persistence.service;

import java.io.Serializable;
import java.util.List;
import java.util.Optional;

import javax.validation.ConstraintViolationException;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.domain.Specification;

import br.gov.mg.meioambiente.exception.AppException;
import br.gov.mg.meioambiente.exception.NotFoundException;
import br.gov.mg.meioambiente.logger.LogMessagem;
import br.gov.mg.meioambiente.persistence.repository.BaseRepository;
import br.gov.mg.meioambiente.validator.EntityOptionalValidator;



public abstract class AbstractService<T, PK extends Serializable> implements BaseCrudService<T, PK> {

	final static String log_listando = "Listando os registros na entidade: {}";
	final static String log_pesquisando = "Pesquisando o registro na entidade: {} identificado {}";
	final static String log_editando = "Editando um novo registro na entidade: {}";
	final static String log_excluindo = "Deleta um novo registro na entidade: {}";
	final static String log_inserindo = "Criando um novo registro na entidade: {}";
	final static String log_sucesso = "Operação realizada com sucesso.";

	protected BaseRepository<T, PK> repository;

	private EntityOptionalValidator<T> validarEntidade;

	public AbstractService(BaseRepository<T, PK> repository) {
		this.repository = repository;
	}

	/**
	 * Valida os dados antes de enviar para o banco de dados.
	 * 
	 * @param entity
	 * @return
	 */
	public abstract boolean isValidacao(T entity);

	/**
	 * Antes de Salvar
	 */
	public abstract void beforeCreate(T entity);

	/**
	 * Depois de Salvar
	 */
	public abstract void afterCreate(T entity);

	/**
	 * Antes de atualizar o registro
	 */
	public abstract void beforeUpdate(T entity);

	/**
	 * Depois de atualizar o registro
	 */
	public abstract void afterUpdate(T entity);

	/**
	 * Antes de deletar o registro
	 */
	public abstract void beforeDelete(T entity);

	/**
	 * Depois de deletar o registro
	 */
	public abstract void afterDelete(T entity);


	public abstract void entityUpdate(T origem, T destino);

	/**
	 * Persiste os dados
	 */
	@Override
	public T createEntity(T entity) {

		new LogMessagem().printInfoLogWithId(log_inserindo, entity.getClass().getSimpleName());

		if (isValidacao(entity)) {
			beforeCreate(entity);
		}

		try {

			repository.saveAndFlush(entity);
			afterCreate(entity);

		} catch (ConstraintViolationException cst) {
			new LogMessagem().printErrorLog(cst);
			throw new ConstraintViolationException (log_inserindo, cst.getConstraintViolations());

		} catch (Exception e) {
			new LogMessagem().printErrorLog(e);
			throw new AppException(log_inserindo, e);
		}

		new LogMessagem().printInfoLog(log_sucesso);
		return entity;
	}

	@Override
	public void delete(T entity) {

		new LogMessagem().printInfoLogWithId(log_excluindo, entity.getClass().getSimpleName());

		beforeDelete(entity);

		try {
			repository.delete(entity);
			afterDelete(entity);
		} catch (Exception e) {
			new LogMessagem().printErrorLog(e);
			throw new AppException(log_excluindo, e);
		}

		new LogMessagem().printInfoLog(log_sucesso);

	}

	@Override
	public void deleteById(PK id) {

		new LogMessagem().printInfoLogWithId(log_excluindo, id);

		T entity = this.getById(id);

		beforeDelete(entity);

		try {
			repository.delete(entity);
			afterDelete(entity);
		} catch (Exception e) {
			new LogMessagem().printErrorLog(e);
			throw new AppException(log_excluindo, e);
		}

		new LogMessagem().printInfoLog(log_sucesso);

	}

	@Override
	public T update(T entity) {

		new LogMessagem().printInfoLogWithId(log_editando, entity.getClass().getSimpleName());

		Optional<T> entityAtual = null;
		//Optional<T> entityAtual = repository.findById( ((BaseEntity<PK>) entity).getId() ); 

        if (entityAtual.get() == null) {
            throw new NotFoundException("resource not found");
        } else {
        	entityUpdate(entityAtual.get(),entity);	
        }		

		if (isValidacao(entityAtual.get())) {
			beforeUpdate(entityAtual.get());
		}
		
        try {

			repository.saveAndFlush(entityAtual.get());
			afterUpdate(entityAtual.get());

		} catch (Exception e) {
			new LogMessagem().printErrorLog(e);
			throw new AppException(log_editando, e);
		}

		new LogMessagem().printInfoLog(log_sucesso);
		return entityAtual.get();

	}

	@Override
	public T update(T entity, PK id) {

		new LogMessagem().printInfoLogWithId(log_editando, entity.getClass().getSimpleName());
		
		Optional<T> entityAtual = repository.findById(id);		

        if (entityAtual.get() == null) {
            throw new NotFoundException("resource not found");
        } else {
        	entityUpdate(entityAtual.get(),entity);	
        }
        
		if (isValidacao(entityAtual.get())) {
			beforeUpdate(entityAtual.get());
		}

		try {

			repository.saveAndFlush(entityAtual.get());
			afterUpdate(entityAtual.get());

		} catch (Exception e) {
			new LogMessagem().printErrorLog(e);
			throw new AppException(log_editando, e);
		}

		new LogMessagem().printInfoLog(log_sucesso);
		return entityAtual.get();

	}

	@Override
	public T getById(PK id) {

		new LogMessagem().printInfoLogWithId(log_pesquisando, id);

		try {
			T entity = this.getById(id);
			validarEntidade.validadatorOptional(entity);
			new LogMessagem().printInfoLog(log_sucesso);
			return entity;
		} catch (Exception e) {
			new LogMessagem().printErrorLog(e);
			throw new AppException(log_pesquisando, e);
		}

	}

	@Override
	public T getById(T entity, PK id) {

		new LogMessagem().printInfoLogWithId(log_pesquisando, entity.getClass().getSimpleName(), id);

		try {
			Optional<T> registro = repository.findById(id);
			validarEntidade.validadatorOptional(registro.get());
		} catch (Exception e) {
			new LogMessagem().printErrorLog(e);
			throw new AppException(log_pesquisando, e);
		}

		new LogMessagem().printInfoLog(log_sucesso);
		return entity;

	}

	@Override
	public List<T> getAll() {

		new LogMessagem().printInfoLog(log_listando);

		List<T> list = null;

		try {

			list = repository.findAll();
			validarEntidade.validadatorOptional(list);

		} catch (Exception e) {
			new LogMessagem().printErrorLog(e);
			throw new AppException(log_listando, e);

		}

		new LogMessagem().printInfoLog(log_sucesso);
		return list;

	}

	@Override
	public Page<T> getAll(Pageable pageable) {
		new LogMessagem().printInfoLog(log_listando);

		Page<T> list = null;

		try {

			list = repository.findAll(pageable);
			// validarEntidade.validadatorOptional(list);

		} catch (Exception e) {
			new LogMessagem().printErrorLog(e);
			throw new AppException(log_listando, e);

		}

		new LogMessagem().printInfoLog(log_sucesso);
		return list;
	}

	@Override
	public Page<T> getByFilter(String search, Pageable pageable) {
		new LogMessagem().printInfoLog(log_listando);

		Page<T> list = null;

		try {

			//list = repository.findAll(search(search), pageable);
			// validarEntidade.validadatorOptional(list);

		} catch (Exception e) {
			new LogMessagem().printErrorLog(e);
			throw new AppException(log_listando, e);

		}

		new LogMessagem().printInfoLog(log_sucesso);
		return list;
	}

	@Override
	public Page<T> getByFilter(Specification<T> spec, Pageable pageable) {
		new LogMessagem().printInfoLog(log_listando);

		Page<T> list = null;

		try {
			list = repository.findAll(spec, pageable);
			validarEntidade.validadatorOptional(list);
		} catch (Exception e) {
			new LogMessagem().printErrorLog(e);
			throw new AppException(log_listando, e);
		}

		new LogMessagem().printInfoLog(log_sucesso);
		return list;

	}

}