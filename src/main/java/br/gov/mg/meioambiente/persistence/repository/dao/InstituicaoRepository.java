package br.gov.mg.meioambiente.persistence.repository.dao;

import org.springframework.stereotype.Repository;

import br.gov.mg.meioambiente.persistence.entity.model.Instituicao;
import br.gov.mg.meioambiente.persistence.repository.BaseRepository;

@Repository
public interface InstituicaoRepository extends BaseRepository<Instituicao, Long> {

}
