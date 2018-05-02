package br.gov.mg.meioambiente.configuracao;

import java.io.IOException;
import java.io.Serializable;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.security.core.AuthenticationException;
import org.springframework.security.web.AuthenticationEntryPoint;
import org.springframework.stereotype.Component;

@Component
public class JwtRestAuthenticationEntryPoint implements AuthenticationEntryPoint, Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 8470094086655767855L;

	@Override
	public void commence(HttpServletRequest request, HttpServletResponse response,
			AuthenticationException authException) throws IOException {

		response.setContentType("application/json;charset=UTF-8");
		response.setCharacterEncoding("UTF-8");
		response.setStatus(HttpServletResponse.SC_UNAUTHORIZED);
		response.setHeader("Access-Control-Allow-Origin", "*");// cross domain request/CORS
		response.getWriter().println("{ \"erro\": \"" + "Usuário não autenticado" + "\" }");

		// response.sendError(HttpServletResponse.SC_UNAUTHORIZED, "Não autorizado");
	}

}
