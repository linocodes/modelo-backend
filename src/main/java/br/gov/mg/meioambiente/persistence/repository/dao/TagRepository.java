package br.gov.mg.meioambiente.persistence.repository.dao;

import org.springframework.stereotype.Repository;

import br.gov.mg.meioambiente.persistence.entity.model.Tag;
import br.gov.mg.meioambiente.persistence.repository.BaseRepository;

@Repository
public interface TagRepository extends BaseRepository<Tag, Long> {

}
