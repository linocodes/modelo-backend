package br.gov.mg.meioambiente.persistence.entity.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;
import javax.validation.constraints.NotNull;

import br.gov.mg.meioambiente.persistence.entity.BaseEntityAudit;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor

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
    @NotNull
	private String sigla;

	@Column(name = "nome", nullable = false)
    @NotNull
	private String nome;

	@Column(name = "contato", nullable = false)
	private String contato;

	@Column(name = "contato_telefone", nullable = false)
	private String contato_telefone;

	@Column(name = "contato_email", nullable = false)
	private String contato_email;

	@Column(name = "observacao")
	private String observacao;

}
