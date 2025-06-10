package com.reds.models.service.dto.request;

import io.swagger.v3.oas.annotations.media.Schema;
import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Size;

@Schema(description = "Requisição das informações do usuário") // Descreve o que está sendo feito na classe
public class UsuarioRequest {
	
	private Long idUsuario;
	private String nomeUsuario;
	private String email;
	// private String senha;
	
	public UsuarioRequest() {
	}	

	public UsuarioRequest(
			Long idUsuario, 
			String nomeUsuario, 
			String email,
			Long salas_jogadas,
			Long vitorias) {
		this.idUsuario = idUsuario;
		this.nomeUsuario = nomeUsuario;
		this.email = email;
	}
	
	public Long getIdUsuario() {
		return idUsuario;
	}


	@Schema(description = "Nome do usuário", example = "Bruno Takeo Acano")
	@NotBlank(message = "O nome do usuário deve ser informado.")
	@Size(max = 100, message = "O nome do usuário deve conter até 100 caracteres.")
	public String getNomeUsuario() {
		return nomeUsuario;
	}

	@Schema(description = "E-mail do usuário", example = "email@gmail.com")
	@NotBlank(message = "O e-mail do usuário deve ser informado.")
	@Size(max = 100, message = "O e-mail do usuário deve conter até 100 caracteres.")
	@Email(message = "E-mail inválido.")
	public String getEmail() {
		return email;
	}

	@Override
	public String toString() {
		return "UsuarioRequest [idUsuario=" + idUsuario + ", codUsuario=" + ", nomeUsuario=" + nomeUsuario
				+ ", email=" + email +  "]";
	}
}
