package br.gov.mg.meioambiente.persistence.service.impl;

import java.io.Serializable;
import java.util.Optional;

import org.slf4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import br.gov.mg.meioambiente.exception.AppException;
import br.gov.mg.meioambiente.logger.Log;
import br.gov.mg.meioambiente.logger.LogBuilder;
import br.gov.mg.meioambiente.persistence.entity.model.Usuario;
import br.gov.mg.meioambiente.persistence.repository.dao.UsuarioRepository;
import br.gov.mg.meioambiente.utils.MensagensErro;



@Service
@Transactional
public class AutenticacaoService implements Serializable {

	private static final long serialVersionUID = 2072262673840561779L;

	@Autowired
	private UsuarioRepository  repository;

	public Usuario autenticaUsuario(Usuario usuario) {

		try {
			
			Optional<Usuario> user = this.repository.findByCpf(usuario.getCpf());
			return user.get();
			
		} catch (Exception e) {
			//logger.error(new LogBuilder().adicionaMensagem("Não foi possível autenticar o usuário")
		//			.adicionaParametro("USUÁRIO", String.valueOf(usuario)).getMensagem(), e);
			throw new AppException(new MensagensErro("erroAutenticacao"));
		}

	}


}
