package br.gov.mg.meioambiente.persistence.repository;

import java.io.Serializable;

import javax.persistence.EntityManager;

import org.springframework.data.jpa.repository.support.JpaEntityInformation;
import org.springframework.data.jpa.repository.support.SimpleJpaRepository;

public class AbstractRepository<T, ID extends Serializable> extends SimpleJpaRepository<T, ID> implements BaseRepository<T, ID> {

	//private EntityManager entityManager;

	public AbstractRepository(JpaEntityInformation<T, ?> entityInformation, EntityManager entityManager) {
		super(entityInformation, entityManager);
		//this.entityManager = entityManager;
	}
	
	/*
	@Transactional
	@Override
	public Optional<T> deleteById(ID id) {
		LOGGER.info("Deleting an entity by using id: {}", id);

		T deleted = entityManager.find(this.getDomainClass(), id);
		LOGGER.debug("Deleted entity is: {}", deleted);

		Optional<T> returned = Optional.empty();

		if (deleted != null) {
			entityManager.remove(deleted);
			returned = Optional.of(deleted);
		}

		LOGGER.info("Returning deleted entity: {}", returned);

		return returned;
	}
	*/

}