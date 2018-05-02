package br.gov.mg.meioambiente.persistence.service.impl;

import java.io.Serializable;

import org.slf4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import br.gov.mg.meioambiente.configuracao.CustomUserDetails;
import br.gov.mg.meioambiente.configuracao.JwtAuthenticationResponse;
import br.gov.mg.meioambiente.configuracao.JwtTokenUtil;
import br.gov.mg.meioambiente.exception.AppException;
import br.gov.mg.meioambiente.logger.Log;
import br.gov.mg.meioambiente.logger.LogBuilder;
import br.gov.mg.meioambiente.persistence.entity.model.Usuario;
import br.gov.mg.meioambiente.utils.MensagensErro;



@Service
@Transactional
public class AutenticacaoService implements Serializable {

	private static final long serialVersionUID = 2072262673840561779L;

	@Log
	private Logger logger;

	@Autowired
	private AuthenticationManager authenticationManager;

	@Autowired
	private JwtTokenUtil jwtTokenUtil;

	@Autowired
	private CustomUserDetailsService userDetailsService;

	public JwtAuthenticationResponse autenticaUsuario(Usuario usuario) {

		try {
			UsernamePasswordAuthenticationToken usernamePasswordAuthenticationToken = new UsernamePasswordAuthenticationToken(
					usuario.getCpf(), usuario.getSenha());
			final Authentication authentication = authenticationManager
					.authenticate(usernamePasswordAuthenticationToken);
			SecurityContextHolder.getContext().setAuthentication(authentication);
			final CustomUserDetails userDetails = userDetailsService.loadUserByUsername(usuario.getCpf());
			final String token = jwtTokenUtil.generateToken(userDetails);
			return new JwtAuthenticationResponse(token, userDetails);
		} catch (Exception e) {
			logger.error(new LogBuilder().adicionaMensagem("Não foi possível autenticar o usuário")
					.adicionaParametro("USUÁRIO", String.valueOf(usuario)).getMensagem(), e);
			throw new AppException(new MensagensErro("erroAutenticacao"));
		}

	}

	public JwtAuthenticationResponse atualizaToken(String token) {
		try {
			if (jwtTokenUtil.canTokenBeRefreshed(token)) {
				String refreshedToken = jwtTokenUtil.refreshToken(token);
				final CustomUserDetails userDetails = userDetailsService
						.loadUserByUsername(jwtTokenUtil.getUsernameFromToken(token));
				return new JwtAuthenticationResponse(refreshedToken, userDetails);
			} else {
				logger.info(new LogBuilder().adicionaMensagem("Token expirado")
						.adicionaParametro("USUÁRIO", String.valueOf(jwtTokenUtil.getUsernameFromToken(token)))
						.getMensagem());
				throw new AppException("token");
			}
		} catch (Exception e) {
			logger.error(new LogBuilder().adicionaMensagem("Erro ao atualizar token")
					.adicionaParametro("TOKEN", String.valueOf(token)).getMensagem());
			throw new AppException("token");
		}
	}

}
