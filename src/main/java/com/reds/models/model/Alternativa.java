package com.reds.models.model;

import java.util.Objects;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.FetchType;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.OneToOne;
import jakarta.persistence.SequenceGenerator;
import jakarta.persistence.Table;

@Entity // Objt/Entidade que está na memória que será persistido.
@Table(name = "REDS_ALTERNATIVA") // Qual tabela fisica armazena a alternativa.
public class Alternativa {
	private Long id_alternativa;
	private String texto;
	private Boolean correta;
	
	private Pergunta pergunta;

	public Alternativa() {
		
	}

	public Alternativa(Long id_alternativa, String texto, Boolean correta, Pergunta pergunta) {
		this.id_alternativa = id_alternativa;
		this.texto = texto;
		this.correta = correta;
		this.pergunta = pergunta;
	}
	
	@Id // Referencia o ID	
	// @GeneratedValue(strategy = GenerationType.IDENTITY)
	@GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "SEQ_REDS_ALTERNATIVA") // Como o banco esta gerenciando a geração de chaves primárias
	@SequenceGenerator(sequenceName = "SEQ_REDS_ALTERNATIVA", initialValue = 1, allocationSize = 1, name = "SEQ_REDS_ALTERNATIVA")
	@Column(name = "id_alternativa")
	public Long getId_Alternativa() {
		return id_alternativa;
	}

	public void setId_Alternativa(Long id_Alternativa) {
		this.id_alternativa = id_Alternativa;
	}
	@Column(name = "texto")
	public String getTexto() {
		return texto;
	}

	public void setTexto(String texto) {
		this.texto = texto;
	}
	@Column(name = "correta")
	public Boolean getCorreta() {
		return correta;
	}

	public void setCorreta(Boolean correta) {
		this.correta = correta;
	}
	@OneToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "id_pergunta", referencedColumnName = "id_pergunta") 
	public Pergunta getPergunta() {
		return pergunta;
	}

	public void setPergunta(Pergunta pergunta) {
		this.pergunta = pergunta;
	}

	@Override
	public int hashCode() {
		return Objects.hash(id_alternativa);
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Alternativa other = (Alternativa) obj;
		return Objects.equals(id_alternativa, other.id_alternativa);
	}

	@Override
	public String toString() {
		return "Alternativa [id_Alternativa=" + id_alternativa + ", texto=" + texto + ", correta=" + correta
				+ ", pergunta=" + pergunta + "]";
	}
	
	
	
}
