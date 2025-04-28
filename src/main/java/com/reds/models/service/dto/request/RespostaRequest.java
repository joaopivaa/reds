package com.reds.models.service.dto.request;

import java.time.LocalDateTime;

import io.swagger.v3.oas.annotations.media.Schema;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Size;

public class RespostaRequest {
	private Long id_resposta;
	private LocalDateTime tempoResposta;
	private String correta;
	
	private String nome_Jogador;
	private String enunciado_Pergunta;
	private String texto_Alternativa;
	
	public RespostaRequest() {
		
	}

	public RespostaRequest(Long id_resposta, LocalDateTime tempoResposta, String correta, String nome_Jogador,
			String enunciado_Pergunta, String texto_Alternativa) {
		this.id_resposta = id_resposta;
		this.tempoResposta = tempoResposta;
		this.correta = correta;
		this.nome_Jogador = nome_Jogador;
		this.enunciado_Pergunta = enunciado_Pergunta;
		this.texto_Alternativa = texto_Alternativa;
	}

	public Long getId_resposta() {
		return id_resposta;
	}
	@Schema(description = "Tempo Que o Jogador Responde", example = "Respondeu, Faltando 45 Segundos Para Acabar")
	public LocalDateTime getTempoResposta() {
		return tempoResposta;
	}
	
	@Schema(description = "Mostra se A Resposta Esta Certa ou Não", example = "1 (Correta), 0 (Falso)", allowableValues = {"1", "2"})
	public String getCorreta() {
		return correta;
	}
	
	@Schema(description = "Nome do Jogador", example = "bruno")
	@NotBlank(message = "O nome do Jogador deve ser informado.")
	@Size(max = 100, message = "O nome do Jogador deve conter até 100 caracteres.")
	public String getNome_Jogador() {
		return nome_Jogador;
	}
	
	@Schema(description = "O Enunciaedo Da Pergunta", example = "O Que E Spring Boot?")
	@NotBlank(message = "Tem Que Colocar o Enunciado")
	@Size(max = 100, message = "O Enunciado deve conter até 100 caracteres.")
	public String getEnunciado_Pergunta() {
		return enunciado_Pergunta;
	}

	public String getTexto_Alternativa() {
		return texto_Alternativa;
	}

	@Override
	public String toString() {
		return "RespostaRequest [id_resposta=" + id_resposta + ", tempoResposta=" + tempoResposta + ", correta="
				+ correta + ", nome_Jogador=" + nome_Jogador + ", enunciado_Pergunta=" + enunciado_Pergunta
				+ ", texto_Alternativa=" + texto_Alternativa + "]";
	}
	
	
}
