package com.reds.models.service.dto.request;

import io.swagger.v3.oas.annotations.media.Schema;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Size;

@Schema(description = "Requisição das informações da Disciplina")
public class DisciplinaRequest {
	
	private Long id_Disciplina;
	private String nome_Disciplina;
	
	public DisciplinaRequest() {
		
	}

	public DisciplinaRequest(Long id_Disciplina, String nome_Disciplina) {
		this.id_Disciplina = id_Disciplina;
		this.nome_Disciplina = nome_Disciplina;
	}

	public Long getId_Disciplina() {
		return id_Disciplina;
	}
	@Schema(description = "Nome Da Disciplina", example = "Java")
	@NotBlank(message = "Tem Que Informar A Disciplina.")
	@Size(max = 100, message = "A Disciplina deve conter até 100 caracteres.")
	public String getNome_Disciplina() {
		return nome_Disciplina;
	}

	@Override
	public String toString() {
		return "DisciplinaRequest [id_Disciplina=" + id_Disciplina + ", nome_Disciplina=" + nome_Disciplina + "]";
	}
	
}
