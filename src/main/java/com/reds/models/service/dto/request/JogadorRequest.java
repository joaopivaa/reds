package com.reds.models.service.dto.request;

import io.swagger.v3.oas.annotations.media.Schema;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Size;

public class JogadorRequest {
	private Long id_Jogador;
	private String nome_Jogador;
	private Long pontuacao;
	
	private Long nome_Usuario;
	private Long codigo_Sala;
	
	public JogadorRequest() {
		
	}

	public JogadorRequest(Long id_Jogador, String nome_Jogador, Long pontuacao, Long nome_Usuario, Long codigo_Sala) {
		this.id_Jogador = id_Jogador;
		this.nome_Jogador = nome_Jogador;
		this.pontuacao = pontuacao;
		this.nome_Usuario = nome_Usuario;
		this.codigo_Sala = codigo_Sala;
	}

	public Long getId_Jogador() {
		return id_Jogador;
	}
	
	@Schema(description = "Nome do Jogador", example = "bruno")
	@NotBlank(message = "O Nome do Jogador Deve Ser Informada")
	@Size(max = 100, message = "O Nome do Jogador deve conter até 100 caracteres.")
	public String getNome_Jogador() {
		return nome_Jogador;
	}
	
	@Schema(description = "Pontuacao do Jogador", example = "125 Pontos")
	@NotBlank(message = "A Pontuação deve Ser Visto")
	public Long getPontuacao() {
		return pontuacao;
	}
	
	@Schema(description = "Nome do usuário", example = "Bruno Takeo Acano")
	@NotBlank(message = "O nome do usuário deve ser informado.")
	@Size(max = 100, message = "O nome do usuário deve conter até 100 caracteres.")
	public Long getNome_Usuario() {
		return nome_Usuario;
	}
	
	@Schema(description = "O Codigo Da Sala", example = "ABCD12")
	@NotBlank(message = "Tem Que Colocar o Codigo")
	@Size(max = 100, message = "O Codigo deve conter até 6 caracteres.")
	public Long geCodigo_Sala() {
		return codigo_Sala;
	}

	@Override
	public String toString() {
		return "JogadorRequest [id_Jogador=" + id_Jogador + ", nome_Jogador=" + nome_Jogador + ", pontuacao="
				+ pontuacao + ", nome_Usuario=" + nome_Usuario + ", codigo_Sala=" + codigo_Sala + "]";
	}
	
}
