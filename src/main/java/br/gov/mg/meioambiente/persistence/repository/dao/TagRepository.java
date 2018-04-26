package br.gov.mg.meioambiente.persistence.repository.dao;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Repository;

import br.gov.mg.meioambiente.persistence.entity.model.Tag;
import br.gov.mg.meioambiente.persistence.repository.BaseRepository;

@Repository
public interface TagRepository extends BaseRepository<Tag, Long> {

	Page<Tag> findByNameStartingWithIgnoreCase(String search, Pageable pageable);

}
