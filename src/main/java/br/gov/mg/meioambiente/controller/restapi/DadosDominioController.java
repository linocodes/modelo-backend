package br.gov.mg.meioambiente.controller.restapi;

import java.io.Serializable;
import org.slf4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import br.gov.mg.meioambiente.enums.Status;
import br.gov.mg.meioambiente.enums.Tipo;
import br.gov.mg.meioambiente.logger.Log;
import br.gov.mg.meioambiente.logger.LogBuilder;



@RestController
@RequestMapping(value = "/dadosDominio")
public class DadosDominioController implements Serializable {

	private static final long serialVersionUID = 8129373421904913884L;

	@Log
	private Logger logger;
	
	/** Método que lista os dados de dominio do tipo
	 * 
	 * @return HTTPStatus 200 e os tipos em formato Json caso a consulta tenha sucesso <br>
	 * @throws Exception */
	@RequestMapping(value = "/tipo", method = RequestMethod.GET)
	public ResponseEntity<?> listarDominioTipo() {

		//logger.info(new LogBuilder().adicionaMensagem("Listando tipo").getMensagem());

		return new ResponseEntity<>(Tipo.values(), HttpStatus.OK);

	}

	/** Método que lista os dados de dominio do status
	 * 
	 * @return HTTPStatus 200 e os status em formato Json caso a consulta tenha sucesso <br>
	 * @throws Exception */
	@RequestMapping(value = "/status", method = RequestMethod.GET)
	public ResponseEntity<?> listarDominioStatus() {

		logger.info(new LogBuilder().adicionaMensagem("Listando status").getMensagem());

		return new ResponseEntity<>(Status.values(), HttpStatus.OK);

	}
	
}
