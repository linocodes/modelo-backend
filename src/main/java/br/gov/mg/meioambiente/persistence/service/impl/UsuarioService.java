package br.gov.mg.meioambiente.persistence.service.impl;

import java.util.List;

import org.slf4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import br.gov.mg.meioambiente.logger.Log;
import br.gov.mg.meioambiente.persistence.entity.model.Pcd;
import br.gov.mg.meioambiente.persistence.entity.model.Usuario;
import br.gov.mg.meioambiente.persistence.repository.dao.TagRepository;
import br.gov.mg.meioambiente.persistence.repository.dao.UsuarioRepository;
import br.gov.mg.meioambiente.persistence.service.AbstractService;

@Service
public class UsuarioService extends AbstractService<Usuario, Long> {

	private final UsuarioRepository usuarioRepository;

	@Autowired
	public UsuarioService(UsuarioRepository usuarioRepository) {
		super(usuarioRepository);
		this.usuarioRepository = usuarioRepository;
	}

	@Override
	public boolean isValidacao(Usuario entity) {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public void beforeCreate(Usuario entity) {
		// TODO Auto-generated method stub

	}

	@Override
	public void afterCreate(Usuario entity) {
		// TODO Auto-generated method stub

	}

	@Override
	public void beforeUpdate(Usuario entity) {
		// TODO Auto-generated method stub

	}

	@Override
	public void afterUpdate(Usuario entity) {
		// TODO Auto-generated method stub

	}

	@Override
	public void beforeDelete(Usuario entity) {
		// TODO Auto-generated method stub

	}

	@Override
	public void afterDelete(Usuario entity) {
		// TODO Auto-generated method stub

	}

	@Override
	public void entityUpdate(Usuario origem, Usuario destino) {
		// TODO Auto-generated method stub

	}

}
