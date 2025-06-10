package com.reds.models.service.dto.request;

import io.swagger.v3.oas.annotations.media.Schema;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Size;

public class SalaRequest {
	private Long id_Sala;
	private String codigo;
	private Long numero_Jogadores;
	private Long qtd_Perguntas;
	private Long tempo_Limite;
	
	private String nomeUsuario;
	private String nome_Disciplina;
	
	public SalaRequest() {
		
	}
	
	public SalaRequest(Long id_Sala, String codigo, Long numero_Jogadores, Long tempo_Limite, String nomeUsuario,
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
	@Schema(description = "O Codigo Da Sala", example = "ABCD12")
	@NotBlank(message = "Tem Que Colocar o Codigo")
	@Size(max = 100, message = "O Codigo deve conter até 6 caracteres.")
	public String getCodigo() {
		return codigo;
	}
	@Schema(description = "Quantidade de Jogadores Na Sala", example = "3")
	@NotBlank(message = "Tem Que Colocar O Numeros de Jogadores")
	@Size(max = 100, message = "A Sala deve conter até 10 Jogadores")
	public Long getNumero_Jogadores() {
		return numero_Jogadores;
	}
	@Schema(description = "Tempo Da Sala", example = "30")
	@NotBlank(message = "Tem Que Colocar O Tempo")
	@Size(max = 100, message = "A Sala deve conter até 60 Segundos")
	public Long getTempo_Limite() {
		return tempo_Limite;
	}
	@Schema(description = "O Criador Da Sala", example = "joaopivaa")
	public String getNomeUsuario() {
		return nomeUsuario;
	}
	@Schema(description = "A Disciplina Da Sala", example = "Java")
	public String getNome_Disciplina() {
		return nome_Disciplina;
	}
	@Schema(description = "Quantidade de Perguntas", example = "2")
	@NotBlank(message = "Tem que Colocar A Quantidade de Perguntas")
	@Size(max = 100, message = "A Sala deve conter até 20 Perguntas")
	public Long getQtd_Perguntas() {
		return qtd_Perguntas;
	}
	
	@Override
	public String toString() {
		return "SalaRequest [id_Sala=" + id_Sala + ", codigo=" + codigo + ", numero_Jogadores=" + numero_Jogadores
				+ ", qtd_Perguntas=" + qtd_Perguntas + ", tempo_Limite=" + tempo_Limite + ", nomeUsuario=" + nomeUsuario
				+ ", nome_Disciplina=" + nome_Disciplina + "]";
	}
	
}
