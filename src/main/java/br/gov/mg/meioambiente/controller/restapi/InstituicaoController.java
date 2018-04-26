package br.gov.mg.meioambiente.controller.restapi;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import br.gov.mg.meioambiente.controller.BaseRestController;
import br.gov.mg.meioambiente.persistence.entity.model.Instituicao;


@RestController
@RequestMapping(value = "instituicao")
public class InstituicaoController extends BaseRestController<Instituicao, Long> {

	@Autowired
	InstituicaoController(InstituicaoService instituicaoService) {
		super(instituicaoService);
	}

}