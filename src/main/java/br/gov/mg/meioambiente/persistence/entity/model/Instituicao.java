package br.gov.mg.meioambiente.persistence.entity.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;

import br.gov.mg.meioambiente.persistence.entity.BaseEntityAudit;

@Entity
@Table(name = "instituicao")
public class Instituicao extends BaseEntityAudit<Long> {

	private static final long serialVersionUID = 1L;

	@Id
	@Column(name = "instituicao_id")
	@SequenceGenerator(name = "instituicao", sequenceName = "seq_instituicao", allocationSize = 1)
	@GeneratedValue(generator = "instituicao", strategy = GenerationType.SEQUENCE)
	private Long id;

	@Column(name = "sigla", nullable = false)
	private String sigla;

	@Column(name = "nome", nullable = false)
	private String nome;

	@Column(name = "contato", nullable = false)
	private String contato;

	@Column(name = "contato_telefone", nullable = false)
	private String contato_telefone;

	@Column(name = "contato_email", nullable = false)
	private String contato_email;

	@Column(name = "observacao")
	private String observacao;

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getSigla() {
		return sigla;
	}

	public void setSigla(String sigla) {
		this.sigla = sigla;
	}

	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}

	public String getContato() {
		return contato;
	}

	public void setContato(String contato) {
		this.contato = contato;
	}

	public String getContato_telefone() {
		return contato_telefone;
	}

	public void setContato_telefone(String contato_telefone) {
		this.contato_telefone = contato_telefone;
	}

	public String getContato_email() {
		return contato_email;
	}

	public void setContato_email(String contato_email) {
		this.contato_email = contato_email;
	}

	public String getObservacao() {
		return observacao;
	}

	public void setObservacao(String observacao) {
		this.observacao = observacao;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = super.hashCode();
		result = prime * result + ((contato == null) ? 0 : contato.hashCode());
		result = prime * result + ((contato_email == null) ? 0 : contato_email.hashCode());
		result = prime * result + ((contato_telefone == null) ? 0 : contato_telefone.hashCode());
		result = prime * result + ((id == null) ? 0 : id.hashCode());
		result = prime * result + ((nome == null) ? 0 : nome.hashCode());
		result = prime * result + ((observacao == null) ? 0 : observacao.hashCode());
		result = prime * result + ((sigla == null) ? 0 : sigla.hashCode());
		return result;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (!super.equals(obj))
			return false;
		if (getClass() != obj.getClass())
			return false;
		Instituicao other = (Instituicao) obj;
		if (contato == null) {
			if (other.contato != null)
				return false;
		} else if (!contato.equals(other.contato))
			return false;
		if (contato_email == null) {
			if (other.contato_email != null)
				return false;
		} else if (!contato_email.equals(other.contato_email))
			return false;
		if (contato_telefone == null) {
			if (other.contato_telefone != null)
				return false;
		} else if (!contato_telefone.equals(other.contato_telefone))
			return false;
		if (id == null) {
			if (other.id != null)
				return false;
		} else if (!id.equals(other.id))
			return false;
		if (nome == null) {
			if (other.nome != null)
				return false;
		} else if (!nome.equals(other.nome))
			return false;
		if (observacao == null) {
			if (other.observacao != null)
				return false;
		} else if (!observacao.equals(other.observacao))
			return false;
		if (sigla == null) {
			if (other.sigla != null)
				return false;
		} else if (!sigla.equals(other.sigla))
			return false;
		return true;
	}
	

	
}
