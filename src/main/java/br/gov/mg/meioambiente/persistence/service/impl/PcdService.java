package br.gov.mg.meioambiente.persistence.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import br.gov.mg.meioambiente.persistence.entity.model.Pcd;
import br.gov.mg.meioambiente.persistence.repository.dao.PcdRepository;
import br.gov.mg.meioambiente.persistence.service.AbstractService;



@Service
public class PcdService extends AbstractService<Pcd, Long> {

	@Autowired
	public PcdService(PcdRepository pcdRepository) {
		super(pcdRepository);
	}

	@Override
	public boolean isValidacao(Pcd entity) {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public void beforeCreate(Pcd entity) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void afterCreate(Pcd entity) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void beforeUpdate(Pcd entity) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void afterUpdate(Pcd entity) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void beforeDelete(Pcd entity) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void afterDelete(Pcd entity) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void entityUpdate(Pcd origem, Pcd destino) {
		// TODO Auto-generated method stub
		
	}

}