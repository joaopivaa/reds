package com.reds.models.model;

import java.util.Objects;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.FetchType;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.SequenceGenerator;
import jakarta.persistence.Table;

@Entity // Objt/Entidade que está na memória que será persistido.
@Table(name = "REDS_PERGUNTA") // Qual tabela fisica armazena a pergunta.
public class Pergunta {
	private Long id_pergunta;
	private String enunciado;
	private String tipo;
	
	private Disciplina disciplina;

	public Pergunta() {
		
	}

	public Pergunta(Long id_pergunta, String enunciado, String tipo, Disciplina disciplina) {
		this.id_pergunta = id_pergunta;
		this.enunciado = enunciado;
		this.tipo = tipo;
		this.disciplina = disciplina;
	}
	
	@Id // Referencia o ID	
	// @GeneratedValue(strategy = GenerationType.IDENTITY)
	@GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "SEQ_REDS_PERGUNTA") // Como o banco esta gerenciando a geração de chaves primárias
	@SequenceGenerator(sequenceName = "SEQ_REDS_PERGUNTA", initialValue = 1, allocationSize = 1, name = "SEQ_REDS_PERGUNTA")
	@Column(name = "id_pergunta")
	public Long getId_pergunta() {
		return id_pergunta;
	}

	public void setId_pergunta(Long id_pergunta) {
		this.id_pergunta = id_pergunta;
	}
	@Column(name = "enunciado")
	public String getEnunciado() {
		return enunciado;
	}

	public void setEnunciado(String enunciado) {
		this.enunciado = enunciado;
	}
	@Column(name = "tipo")
	public String getTipo() {
		return tipo;
	}

	public void setTipo(String tipo) {
		this.tipo = tipo;
	}
	@ManyToOne(fetch = FetchType.LAZY) 
	@JoinColumn(name = "id_disciplina", referencedColumnName = "id_disciplina") 
	public Disciplina getDisciplina() {
		return disciplina;
	}

	public void setDisciplina(Disciplina disciplina) {
		this.disciplina = disciplina;
	}

	@Override
	public int hashCode() {
		return Objects.hash(id_pergunta);
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Pergunta other = (Pergunta) obj;
		return Objects.equals(id_pergunta, other.id_pergunta);
	}

	@Override
	public String toString() {
		return "Pergunta [id_pergunta=" + id_pergunta + ", enunciado=" + enunciado + ", tipo=" + tipo + ", disciplina="
				+ disciplina + "]";
	}
	
	
}
