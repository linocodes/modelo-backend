package br.gov.mg.meioambiente.controller.restapi;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import br.gov.mg.meioambiente.controller.BaseRestController;
import br.gov.mg.meioambiente.persistence.entity.model.Tag;
import br.gov.mg.meioambiente.persistence.service.impl.TagService;

@RestController
@RequestMapping(value = "tag")
public class TagController extends BaseRestController<Tag, Long> {

	@Autowired
	TagController(TagService tagService) {
		super(tagService);
	}

}