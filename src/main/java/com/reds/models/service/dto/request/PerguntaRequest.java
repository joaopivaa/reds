package com.reds.models.service.dto.request;

import io.swagger.v3.oas.annotations.media.Schema;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Size;

@Schema(description = "Requisição das informações da Pergunta")
public class PerguntaRequest {
	private Long id_usuario;
	private String enunciado;
	private String tipo;
	
	private String nome_disciplina;

	public PerguntaRequest() {
		
	}

	public PerguntaRequest(Long id_usuario, String enunciado, String tipo, String nome_disciplina) {
		this.id_usuario = id_usuario;
		this.enunciado = enunciado;
		this.tipo = tipo;
		this.nome_disciplina = nome_disciplina;
	}

	public Long getId_usuario() {
		return id_usuario;
	}
	
	@Schema(description = "O Enunciaedo Da Pergunta", example = "O Que E Spring Boot?")
	@NotBlank(message = "Tem Que Colocar o Enunciado")
	@Size(max = 100, message = "O Enunciado deve conter até 100 caracteres.")
	public String getEnunciado() {
		return enunciado;
	}
	
	@Schema(description = "Tipo Da Pergunta", example = "Múltipla Escolha, Verdadeiro ou Falso",allowableValues = {"Múltipla Escolha", "Verdadeiro ou Falso"})
	@NotNull(message = "Precisa Escolher o Tipo Da Pergunta")
	public String getTipo() {
		return tipo;
	}
	
	@Schema(description = "Nome Da Disciplina", example = "Java")
	public String getNome_disciplina() {
		return nome_disciplina;
	}

	@Override
	public String toString() {
		return "PerguntaRequest [id_usuario=" + id_usuario + ", enunciado=" + enunciado + ", tipo=" + tipo
				+ ", nome_disciplina=" + nome_disciplina + "]";
	}
	
}
