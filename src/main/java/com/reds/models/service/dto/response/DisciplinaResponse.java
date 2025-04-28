package com.reds.models.service.dto.response;

public class DisciplinaResponse {
	
	private Long id_Disciplina;
	private String nome_Disciplina;
	
	public DisciplinaResponse() {
		
	}

	public DisciplinaResponse(Long id_Disciplina, String nome_Disciplina) {
		this.id_Disciplina = id_Disciplina;
		this.nome_Disciplina = nome_Disciplina;
	}

	public Long getId_Disciplina() {
		return id_Disciplina;
	}

	public void setId_Disciplina(Long id_Disciplina) {
		this.id_Disciplina = id_Disciplina;
	}

	public String getNome_Disciplina() {
		return nome_Disciplina;
	}

	public void setNome_Disciplina(String nome_Disciplina) {
		this.nome_Disciplina = nome_Disciplina;
	}

	@Override
	public String toString() {
		return "DisciplinaResponse [id_Disciplina=" + id_Disciplina + ", nome_Disciplina=" + nome_Disciplina + "]";
	}
	
}
