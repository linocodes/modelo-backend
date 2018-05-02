package br.gov.mg.meioambiente.configuracao;

import java.io.Serializable;

import br.gov.mg.meioambiente.persistence.entity.model.Usuario;


public class JwtAuthenticationResponse implements Serializable {

	/**
	* 
	*/
	private static final long serialVersionUID = 59853608261872447L;
	private final String token;
	private final String nome;
	
	public JwtAuthenticationResponse(String token, Usuario usuario) {
		this.token = token;
		this.nome = usuario.getNome();
	}

	public String getToken() {
		return this.token;
	}

	public String getNome() {
		return nome;
	}

}

