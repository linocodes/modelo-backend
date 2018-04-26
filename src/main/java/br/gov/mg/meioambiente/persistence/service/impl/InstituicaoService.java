package br.gov.mg.meioambiente.persistence.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import br.gov.mg.meioambiente.persistence.entity.model.Instituicao;
import br.gov.mg.meioambiente.persistence.repository.dao.InstituicaoRepository;
import br.gov.mg.meioambiente.persistence.service.AbstractService;


@Service
public class InstituicaoService extends AbstractService<Instituicao, Long> {

	@Autowired
	public InstituicaoService(InstituicaoRepository instituicaoRepository) {
		super(instituicaoRepository);
	}

	@Override
	public boolean isValidacao(Instituicao entity) {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public void beforeCreate(Instituicao entity) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void afterCreate(Instituicao entity) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void beforeUpdate(Instituicao entity) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void afterUpdate(Instituicao entity) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void beforeDelete(Instituicao entity) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void afterDelete(Instituicao entity) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void entityUpdate(Instituicao origem, Instituicao destino) {
		// TODO Auto-generated method stub
		
	}


}