package com.reds.models.service.dto.response;

public class AlternativaResponse {
	private Long id_Alternativa;
	private String texto;
	private Boolean correta;
	
	private String enunciado;

	public AlternativaResponse() {
		
	}

	public AlternativaResponse(Long id_Alternativa, String texto, Boolean correta, String enunciado) {
		this.id_Alternativa = id_Alternativa;
		this.texto = texto;
		this.correta = correta;
		this.enunciado = enunciado;
	}

	public Long getId_Alternativa() {
		return id_Alternativa;
	}

	public void setId_Alternativa(Long id_Alternativa) {
		this.id_Alternativa = id_Alternativa;
	}

	public String getTexto() {
		return texto;
	}

	public void setTexto(String texto) {
		this.texto = texto;
	}

	public Boolean getCorreta() {
		return correta;
	}

	public void setCorreta(Boolean correta) {
		this.correta = correta;
	}

	public String getEnunciado() {
		return enunciado;
	}

	public void setEnunciado(String enunciado) {
		this.enunciado = enunciado;
	}

	@Override
	public String toString() {
		return "AlternativaResponse [id_Alternativa=" + id_Alternativa + ", texto=" + texto + ", correta=" + correta
				+ ", enunciado=" + enunciado + "]";
	}
	
}
