package br.gov.mg.meioambiente.persistence.entity.model;

import javax.persistence.AttributeOverride;
import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;

import br.gov.mg.meioambiente.persistence.entity.BaseEntityAudit;

@Entity
@Table(name = "pcd")
@AttributeOverride(name = "id", column = @Column(name = "pcd_id", nullable = false))
//@SequenceGenerator(sequenceName = "customer_pcd", allocationSize = 1, name = "SEQ_PCD")
public class Pcd extends BaseEntityAudit<Long> {
	
	private static final long serialVersionUID = -1390992359712683300L;
	
	@Column(name="codigo", nullable=false)
	private String codigo;
	
	@Column(name="nome", nullable=false)
	private String nome;
	
	@Column(name="instituicao", nullable=false)
	private String instituicao;
	
	@Column(name="latitude", nullable=false)
	private String latitude;
	
	@Column(name="longitude", nullable=false)
	private String longitude;
	
	@Column(name="altitude", nullable=false)
	private String altitude;
	
	@Column(name="municipio", nullable=false)
	private String municipio;
	
	@Column(name="tipo", nullable=false)
	private String tipo;
	
	@Column(name="status", nullable=false)
	private String status;
	
	@Column(name="automatica", nullable=false, length = 1)
	private Long automatica;

	
	//-------------- Get's & Set's -------------------
	
	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getCodigo() {
		return codigo;
	}

	public void setCodigo(String codigo) {
		this.codigo = codigo;
	}

	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}

	public String getInstituicao() {
		return instituicao;
	}

	public void setInstituicao(String instituicao) {
		this.instituicao = instituicao;
	}

	public String getLatitude() {
		return latitude;
	}

	public void setLatitude(String latitude) {
		this.latitude = latitude;
	}

	public String getLongitude() {
		return longitude;
	}

	public void setLongitude(String longitude) {
		this.longitude = longitude;
	}

	public String getAltitude() {
		return altitude;
	}

	public void setAltitude(String altitude) {
		this.altitude = altitude;
	}

	public String getMunicipio() {
		return municipio;
	}

	public void setMunicipio(String municipio) {
		this.municipio = municipio;
	}

	public String getTipo() {
		return tipo;
	}

	public void setTipo(String tipo) {
		this.tipo = tipo;
	}

	public String getStatus() {
		return status;
	}

	public void setStatus(String status) {
		this.status = status;
	}

	
	public Long getAutomatica() {
		return automatica;
	}

	public void setAutomatica(Long automatica) {
		this.automatica = automatica;
	}

	public Pcd() {}
	

	


}
