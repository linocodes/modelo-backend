package br.gov.mg.meioambiente.controller.restapi;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import br.gov.mg.meioambiente.controller.BaseRestController;
import br.gov.mg.meioambiente.persistence.entity.model.Pcd;
import br.gov.mg.meioambiente.persistence.service.impl.PcdService;

@RestController
@RequestMapping(value = "pcd")
public class PcdController extends BaseRestController<Pcd, Long> {

	@Autowired
	PcdController(PcdService pcdService) {
		super(pcdService);
	}

}