package com.reds.models.service.dto.response;

public class PerguntaResponse {
	
	private Long id_usuario;
	private String enunciado;
	private String tipo;
	
	private String nome_disciplina;

	public PerguntaResponse() {
		
	}

	public PerguntaResponse(Long id_usuario, String enunciado, String tipo, String nome_disciplina) {
		this.id_usuario = id_usuario;
		this.enunciado = enunciado;
		this.tipo = tipo;
		this.nome_disciplina = nome_disciplina;
	}

	public Long getId_usuario() {
		return id_usuario;
	}

	public void setId_usuario(Long id_usuario) {
		this.id_usuario = id_usuario;
	}

	public String getEnunciado() {
		return enunciado;
	}

	public void setEnunciado(String enunciado) {
		this.enunciado = enunciado;
	}

	public String getTipo() {
		return tipo;
	}

	public void setTipo(String tipo) {
		this.tipo = tipo;
	}

	public String getNome_disciplina() {
		return nome_disciplina;
	}

	public void setNome_disciplina(String nome_disciplina) {
		this.nome_disciplina = nome_disciplina;
	}

	@Override
	public String toString() {
		return "PerguntaResponse [id_usuario=" + id_usuario + ", enunciado=" + enunciado + ", tipo=" + tipo
				+ ", nome_disciplina=" + nome_disciplina + "]";
	}
	
}
