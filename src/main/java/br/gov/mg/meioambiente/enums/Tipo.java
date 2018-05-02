package br.gov.mg.meioambiente.enums;

import com.fasterxml.jackson.annotation.JsonFormat;

@JsonFormat(shape = JsonFormat.Shape.OBJECT)
public enum Tipo {
	METEOROLOGIA("Meteorológica"), AGRoMETEOROLOGIA("Agrometeorológica"),
	HIDROLOGIA("Hidrológica"), QUALIDADE_DA_AGUA("Qualidade da Água"), 
	METAR("METAR"), SYNOP("SYNOP");

	private String descricao;

	Tipo(String descricao) {
		this.descricao = descricao;
	}

	public String getName() {
		return this.name();
	}

	public String getDescricao() {
		return descricao;
	}
}