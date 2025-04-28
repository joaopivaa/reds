package com.reds.models.service.dto.response;

public class UsuarioResponse {
	
	private Long idUsuario;
	private String nomeUsuario;
	private String email;
	private Long salas_jogadas;
	private Long vitorias;
	
	public UsuarioResponse() {
	}
	
	public UsuarioResponse(Long idUsuario, String nomeUsuario, String email) {
		this.idUsuario = idUsuario;
		this.nomeUsuario = nomeUsuario;
		this.email = email;
	}

	public UsuarioResponse(Long idUsuario, String codUsuario, String nomeUsuario, String email, Long salas_jogadas,
			Long vitorias) {
		this.idUsuario = idUsuario;
		this.nomeUsuario = nomeUsuario;
		this.email = email;
		this.salas_jogadas = salas_jogadas;
		this.vitorias = vitorias;
	}

	public Long getIdUsuario() {
		return idUsuario;
	}

	public void setIdUsuario(Long idUsuario) {
		this.idUsuario = idUsuario;
	}

	public String getNomeUsuario() {
		return nomeUsuario;
	}

	public void setNomeUsuario(String nomeUsuario) {
		this.nomeUsuario = nomeUsuario;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public Long getSalas_jogadas() {
		return salas_jogadas;
	}

	public void setSalas_jogadas(Long salas_jogadas) {
		this.salas_jogadas = salas_jogadas;
	}

	public Long getVitorias() {
		return vitorias;
	}

	public void setVitorias(Long vitorias) {
		this.vitorias = vitorias;
	}

	@Override
	public String toString() {
		return "UsuarioResponse [idUsuario=" + idUsuario + ", nomeUsuario=" + nomeUsuario + ", email=" + email
				+ ", salas_jogadas=" + salas_jogadas + ", vitorias=" + vitorias + "]";
	}
	
}
