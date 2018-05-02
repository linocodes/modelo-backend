package br.gov.mg.meioambiente.controller.restapi;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import br.gov.mg.meioambiente.controller.BaseRestController;
import br.gov.mg.meioambiente.persistence.entity.model.Usuario;
import br.gov.mg.meioambiente.persistence.service.impl.PcdService;
import br.gov.mg.meioambiente.persistence.service.impl.UsuarioService;

@RestController
@RequestMapping(value="/usuario")
public class UsuarioController extends BaseRestController<Usuario, Long>{

	@Autowired
	UsuarioController(UsuarioService usuarioService) {
		super(usuarioService);
	}

}
