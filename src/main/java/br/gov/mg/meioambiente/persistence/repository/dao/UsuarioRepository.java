package br.gov.mg.meioambiente.persistence.repository.dao;

import java.util.List;
import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;

import br.gov.mg.meioambiente.persistence.entity.model.Usuario;
import br.gov.mg.meioambiente.persistence.repository.BaseRepository;


public interface UsuarioRepository extends BaseRepository<Usuario, Long>{

	public List<Usuario> findAllByOrderByNomeAsc();
	
	Optional<Usuario> findByCpf(String cpf);	
	
}
