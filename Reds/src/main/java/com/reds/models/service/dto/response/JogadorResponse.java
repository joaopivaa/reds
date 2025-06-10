package com.reds.models.service.dto.response;

public class JogadorResponse {
	private Long id_Jogador;
	private String nome_Jogador;
	private Long pontuacao;
	
	private Long id_usuario;
	private Long id_sala;
	
	public JogadorResponse() {
		
	}

	public JogadorResponse(Long id_Jogador, String nome_Jogador, Long pontuacao, Long id_usuario, Long id_sala) {
		this.id_Jogador = id_Jogador;
		this.nome_Jogador = nome_Jogador;
		this.pontuacao = pontuacao;
		this.id_usuario = id_usuario;
		this.id_sala = id_sala;
	}

	public Long getId_Jogador() {
		return id_Jogador;
	}

	public void setId_Jogador(Long id_Jogador) {
		this.id_Jogador = id_Jogador;
	}

	public String getNome_Jogador() {
		return nome_Jogador;
	}

	public void setNome_Jogador(String nome_Jogador) {
		this.nome_Jogador = nome_Jogador;
	}

	public Long getPontuacao() {
		return pontuacao;
	}

	public void setPontuacao(Long pontuacao) {
		this.pontuacao = pontuacao;
	}

	public Long getId_usuario() {
		return id_usuario;
	}

	public void setId_usuario(Long id_usuario) {
		this.id_usuario = id_usuario;
	}

	public Long getId_sala() {
		return id_sala;
	}

	public void setId_sala(Long id_sala) {
		this.id_sala = id_sala;
	}

	@Override
	public String toString() {
		return "JogadorResponse [id_Jogador=" + id_Jogador + ", nome_Jogador=" + nome_Jogador + ", pontuacao="
				+ pontuacao + ", id_usuario=" + id_usuario + ", id_sala=" + id_sala + "]";
	}
	
}
