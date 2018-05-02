package br.gov.mg.meioambiente.controller.restapi;

import java.io.Serializable;

import javax.servlet.http.HttpServletRequest;

import org.slf4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.Errors;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import br.gov.mg.meioambiente.logger.Log;
import br.gov.mg.meioambiente.logger.LogBuilder;
import br.gov.mg.meioambiente.persistence.entity.model.Usuario;
import br.gov.mg.meioambiente.persistence.service.impl.AutenticacaoService;

@RestController
@RequestMapping(value = "/autenticacao")
public class AutenticacaoController implements Serializable {

	private static final long serialVersionUID = -5457292041973488109L;

	@Log
	private Logger logger;

	@Autowired
	private AutenticacaoService autenticacaoService;

	/** Método que autentica um usuário e cria o token de acesso
	 * 
	 * @param usuario - Objeto no formato Json que represente um usuario
	 * @return HTTPStatus 200 e o token do usuário autenticado em formato Json caso a autenticação tenha sucesso <br>
	 *         HTTP Status 400 e mensagem de erro em formato Json caso os parâmetros sejam inválidos <br>
	 *         HTTP Status 401 e mensagem de erro caso o usuário não esteja autorizado */
	@RequestMapping(value = "/criarToken", method = RequestMethod.POST)
	public ResponseEntity<?> createAuthenticationToken(@RequestBody Usuario usuario, Errors errors) {

		logger.info(new LogBuilder().adicionaMensagem("Autenticando usuario")
				.adicionaParametro("Usuario", usuario.toString()).getMensagem());

		//if (errors.hasErrors()) {
		//	throw new ParametrosInvalidosExceptionIdm(MensagensErro.getAtributosInvalidos(errors));
		//}

		return ResponseEntity.ok(autenticacaoService.autenticaUsuario(usuario));
	}

	/** Método que atualiza o token de acesso
	 * 
	 * @param request - Requisição com cabeçalho contendo o token
	 * @return HTTPStatus 200 e o token do usuário autenticado em formato Json caso a atualização tenha sucesso <br>
	 *         HTTP Status 400 e mensagem de erro em formato Json caso os parâmetros sejam inválidos */
	@RequestMapping(value = "/atualizarToken", method = RequestMethod.GET)
	public ResponseEntity<?> refreshAndGetAuthenticationToken(HttpServletRequest request) {

		logger.info(new LogBuilder().adicionaMensagem("Atualizando token de acesso").getMensagem());

		String token = request.getHeader("Authorization");
		return ResponseEntity.ok(autenticacaoService.atualizaToken(token));

	}

}
