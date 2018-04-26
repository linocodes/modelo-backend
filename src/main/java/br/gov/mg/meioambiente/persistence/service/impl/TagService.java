package br.gov.mg.meioambiente.persistence.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import br.gov.mg.meioambiente.logger.LogMessagem;
import br.gov.mg.meioambiente.persistence.entity.model.Tag;
import br.gov.mg.meioambiente.persistence.repository.dao.TagRepository;
import br.gov.mg.meioambiente.persistence.service.AbstractService;

@Service
public class TagService extends AbstractService<Tag, Long> {

	private final TagRepository tagRepository;

	@Autowired
	public TagService(TagRepository tagRepository) {
		super(tagRepository);
		this.tagRepository = tagRepository;
	}

	@Override
	public boolean isValidacao(Tag entity) {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public void beforeCreate(Tag entity) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void afterCreate(Tag entity) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void beforeUpdate(Tag entity) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void afterUpdate(Tag entity) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void beforeDelete(Tag entity) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void afterDelete(Tag entity) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void entityUpdate(Tag origem, Tag destino) {
		// TODO Auto-generated method stub
		
	}
	
	

/*

	@Override
	public Page<Tag> getByFilter(String search, Pageable pageable) {
		new LogMessagem().printInfoLog(log_listando);

		Page<Tag> list = null;

		try {
			list = tagRepository.findByNameStartingWithIgnoreCase(search, pageable);
			// validarEntidade.validadatorOptional(list);

		} catch (Exception e) {
			new LogMessagem().printErrorLog(e);
			throw new AppException(log_listando, e);

		}

		new LogMessagem().printInfoLog(log_sucesso);
		return list;
	}
	*/
	
	

}