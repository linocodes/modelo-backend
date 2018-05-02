package br.gov.mg.meioambiente.enums;

import com.fasterxml.jackson.annotation.JsonFormat;

@JsonFormat(shape = JsonFormat.Shape.OBJECT)
public enum Status {
	ATIVA("Ativa"), INATIVA("Inativa"),
	MANUTENCAO("Manutenção");

	private String descricao;

	Status(String descricao) {
		this.descricao = descricao;
	}

	public String getName() {
		return this.name();
	}

	public String getDescricao() {
		return descricao;
	}
}