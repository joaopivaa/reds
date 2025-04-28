package com.reds.models.service.dto.response;

public class SalaResponse {
	private Long id_Sala;
	private String codigo;
	private Long numero_Jogadores;
	private Long tempo_Limite;
	private Long qtd_Perguntas;
	
	private String nomeUsuario;
	private String nome_Disciplina;
	
	public SalaResponse() {
		
	}

	public SalaResponse(Long id_Sala, String codigo, Long numero_Jogadores, Long tempo_Limite, String nomeUsuario,
			String nome_Disciplina) {
		this.id_Sala = id_Sala;
		this.codigo = codigo;
		this.numero_Jogadores = numero_Jogadores;
		this.tempo_Limite = tempo_Limite;
		this.nomeUsuario = nomeUsuario;
		this.nome_Disciplina = nome_Disciplina;
	}

	public Long getId_Sala() {
		return id_Sala;
	}

	public void setId_Sala(Long id_Sala) {
		this.id_Sala = id_Sala;
	}

	public String getCodigo() {
		return codigo;
	}

	public void setCodigo(String codigo) {
		this.codigo = codigo;
	}

	public Long getNumero_Jogadores() {
		return numero_Jogadores;
	}

	public void setNumero_Jogadores(Long numero_Jogadores) {
		this.numero_Jogadores = numero_Jogadores;
	}

	public Long getTempo_Limite() {
		return tempo_Limite;
	}

	public void setTempo_Limite(Long tempo_Limite) {
		this.tempo_Limite = tempo_Limite;
	}

	public String getNomeUsuario() {
		return nomeUsuario;
	}

	public void setNomeUsuario(String nomeUsuario) {
		this.nomeUsuario = nomeUsuario;
	}

	public String getNome_Disciplina() {
		return nome_Disciplina;
	}

	public void setNome_Disciplina(String nome_Disciplina) {
		this.nome_Disciplina = nome_Disciplina;
	}

	public Long getQtd_Perguntas() {
		return qtd_Perguntas;
	}

	public void setQtd_Perguntas(Long qtd_Perguntas) {
		this.qtd_Perguntas = qtd_Perguntas;
	}

	@Override
	public String toString() {
		return "SalaResponse [id_Sala=" + id_Sala + ", codigo=" + codigo + ", numero_Jogadores=" + numero_Jogadores
				+ ", tempo_Limite=" + tempo_Limite + ", qtd_Perguntas=" + qtd_Perguntas + ", nomeUsuario=" + nomeUsuario
				+ ", nome_Disciplina=" + nome_Disciplina + "]";
	}
	
}
