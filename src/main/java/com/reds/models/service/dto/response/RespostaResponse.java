package com.reds.models.service.dto.response;

import java.time.LocalDateTime;

public class RespostaResponse {
	private Long id_resposta;
	private LocalDateTime tempoResposta;
	private String correta;
	
	private String nome_Jogador;
	private String enunciado_Pergunta;
	private String texto_Alternativa;
	
	public RespostaResponse() {
		
	}

	public RespostaResponse(Long id_resposta, LocalDateTime tempoResposta, String correta, String nome_Jogador,
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

	public void setId_resposta(Long id_resposta) {
		this.id_resposta = id_resposta;
	}

	public LocalDateTime getTempoResposta() {
		return tempoResposta;
	}

	public void setTempoResposta(LocalDateTime tempoResposta) {
		this.tempoResposta = tempoResposta;
	}

	public String getCorreta() {
		return correta;
	}

	public void setCorreta(String correta) {
		this.correta = correta;
	}

	public String getNome_Jogador() {
		return nome_Jogador;
	}

	public void setNome_Jogador(String nome_Jogador) {
		this.nome_Jogador = nome_Jogador;
	}

	public String getEnunciado_Pergunta() {
		return enunciado_Pergunta;
	}

	public void setEnunciado_Pergunta(String enunciado_Pergunta) {
		this.enunciado_Pergunta = enunciado_Pergunta;
	}

	public String getTexto_Alternativa() {
		return texto_Alternativa;
	}

	public void setTexto_Alternativa(String texto_Alternativa) {
		this.texto_Alternativa = texto_Alternativa;
	}

	@Override
	public String toString() {
		return "RespostaRequest [id_resposta=" + id_resposta + ", tempoResposta=" + tempoResposta + ", correta="
				+ correta + ", nome_Jogador=" + nome_Jogador + ", enunciado_Pergunta=" + enunciado_Pergunta
				+ ", texto_Alternativa=" + texto_Alternativa + "]";
	}
	
	
}
