package com.reds.models.service.dto.request;

import io.swagger.v3.oas.annotations.media.Schema;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Size;

public class AlternativaRequest {
	private Long id_Alternativa;
	private String texto;
	private Boolean correta;
	
	private String enunciado;

	public AlternativaRequest() {
		
	}

	public AlternativaRequest(Long id_Alternativa, String texto, Boolean correta, String enunciado) {
		this.id_Alternativa = id_Alternativa;
		this.texto = texto;
		this.correta = correta;
		this.enunciado = enunciado;
	}

	public Long getId_Alternativa() {
		return id_Alternativa;
	}
	
	@Schema(description = "O Texto da Alternativa", example = "Uma Biblioteca")
	@NotBlank(message = "Tem Que Colocar o Texto")
	@Size(max = 100, message = "O Texto deve conter até 100 caracteres.")
	public String getTexto() {
		return texto;
	}

	@Schema(description = "A Alternativa Correta", example = "1 (Correta), 0 (Falso)", allowableValues = {"1", "2"})
	@NotNull(message = "Precisa Escolher A Correta")
	public Boolean getCorreta() {
		return correta;
	}
	
	@Schema(description = "O Enunciaedo Da Pergunta", example = "O Que E Spring Boot?")
	public String getEnunciado() {
		return enunciado;
	}

	@Override
	public String toString() {
		return "AlternativaRequest [id_Alternativa=" + id_Alternativa + ", texto=" + texto + ", correta=" + correta
				+ ", enunciado=" + enunciado + "]";
	}

	
}
