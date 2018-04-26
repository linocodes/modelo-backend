package br.gov.mg.meioambiente.persistence.repository.dao;

import org.springframework.stereotype.Repository;

import br.gov.mg.meioambiente.persistence.entity.model.Pcd;
import br.gov.mg.meioambiente.persistence.repository.BaseRepository;

@Repository
public interface PcdRepository extends BaseRepository<Pcd, Long> {

}
