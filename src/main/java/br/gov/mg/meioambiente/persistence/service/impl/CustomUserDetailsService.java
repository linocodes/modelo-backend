package br.gov.mg.meioambiente.persistence.service.impl;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import br.gov.mg.meioambiente.configuracao.CustomUserDetails;
import br.gov.mg.meioambiente.persistence.entity.model.Usuario;
import br.gov.mg.meioambiente.persistence.repository.dao.UsuarioRepository;



@Service
public class CustomUserDetailsService implements UserDetailsService {

	@Autowired
	private UsuarioRepository usuarioRepository;

	@Override
	public CustomUserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
		Optional<Usuario> usersOptional = usuarioRepository.findByCpf(username);

		//usersOptional.orElseThrow(() -> new UsernameNotFoundException("Username not found!"));
		//return usersOptional.map(CustomUserDetails::new).get();
		return (CustomUserDetails) usersOptional.get();
	}

}
