package br.gov.mg.meioambiente.persistence.service.impl;

import java.util.List;

import org.slf4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import br.gov.mg.meioambiente.persistence.entity.model.ContatoInstituicao;
import br.gov.mg.meioambiente.persistence.repository.dao.ContatoInstituicaoRepository;
import br.gov.mg.meioambiente.persistence.repository.dao.InstituicaoRepository;
import br.gov.mg.meioambiente.persistence.service.AbstractService;


@Service
public class ContatoInstituicaoService extends AbstractService<ContatoInstituicao, Long>{

	@Autowired
	public ContatoInstituicaoService(ContatoInstituicaoRepository contatoInstituicaoRepository) {
		super(contatoInstituicaoRepository);
	}

	@Override
	public boolean isValidacao(ContatoInstituicao entity) {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public void beforeCreate(ContatoInstituicao entity) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void afterCreate(ContatoInstituicao entity) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void beforeUpdate(ContatoInstituicao entity) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void afterUpdate(ContatoInstituicao entity) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void beforeDelete(ContatoInstituicao entity) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void afterDelete(ContatoInstituicao entity) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void entityUpdate(ContatoInstituicao origem, ContatoInstituicao destino) {
		// TODO Auto-generated method stub
		
	}
		
}
