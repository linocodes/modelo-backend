package br.gov.mg.meioambiente.persistence.entity.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;

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
@Table(name = "pcd")
public class Pcd extends BaseEntityAudit<Long> {

	private static final long serialVersionUID = -1390992359712683300L;

	@Id
	@Column(name = "pcd_id")
	@SequenceGenerator(name = "pcd", sequenceName = "seq_pcd", allocationSize = 1)
	@GeneratedValue(generator = "pcd", strategy = GenerationType.SEQUENCE)
	private Long id;

	@Column(name = "codigo", nullable = false)
	private String codigo;

	@Column(name = "nome", nullable = false)
	private String nome;

	@Column(name = "instituicao", nullable = false)
	private String instituicao;

	@Column(name = "latitude", nullable = false)
	private String latitude;

	@Column(name = "longitude", nullable = false)
	private String longitude;

	@Column(name = "altitude", nullable = false)
	private String altitude;

	@Column(name = "municipio", nullable = false)
	private String municipio;

	@Column(name = "tipo", nullable = false)
	private String tipo;

	@Column(name = "status", nullable = false)
	private String status;

	@Column(name = "automatica", nullable = false, length = 1)
	private Long automatica;

}
