package br.gov.mg.meioambiente.configuracao;

import java.io.IOException;

import javax.servlet.FilterChain;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.slf4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.web.authentication.WebAuthenticationDetailsSource;
import org.springframework.web.filter.OncePerRequestFilter;

import br.gov.mg.meioambiente.exception.AppException;
import br.gov.mg.meioambiente.logger.Log;
import br.gov.mg.meioambiente.logger.LogBuilder;
import br.gov.mg.meioambiente.persistence.service.impl.CustomUserDetailsService;
import br.gov.mg.meioambiente.utils.MensagensErro;


public class JwtAuthenticationTokenFilter extends OncePerRequestFilter {

	@Log
	private Logger logger;

	@Autowired
	private CustomUserDetailsService userDetailsService;

	@Autowired
	private JwtTokenUtil jwtTokenUtil;

	private static final String TOKEN_HEADER = "Authorization";

	@Override
	protected void doFilterInternal(HttpServletRequest request, HttpServletResponse response, FilterChain filterChain) throws ServletException, IOException {

		String authToken = request.getHeader(TOKEN_HEADER);
		String username = jwtTokenUtil.getUsernameFromToken(authToken);

		logger.info(new LogBuilder().adicionaMensagem("Checando autenticação para usuário")
				.adicionaParametro("USUÁRIO", String.valueOf(username)).getMensagem());

		if (username != null && SecurityContextHolder.getContext().getAuthentication() == null) {

			try {
				CustomUserDetails userDetails = userDetailsService.loadUserByUsername(username);

				if (jwtTokenUtil.validateToken(authToken, userDetails)) {
					UsernamePasswordAuthenticationToken authentication = new UsernamePasswordAuthenticationToken(
							userDetails, null, userDetails.getAuthorities());
					authentication.setDetails(new WebAuthenticationDetailsSource().buildDetails(request));
					SecurityContextHolder.getContext().setAuthentication(authentication);
				}
			} catch (UsernameNotFoundException e) {
				logger.error(new LogBuilder().adicionaMensagem("Usuário não encontrado")
						.adicionaParametro("USUÁRIO", String.valueOf(username)).getMensagem(), e);
				throw new AppException(new MensagensErro("erroAutenticacao"));
			}
		}

		filterChain.doFilter(request, response);
	}

}
