package com.reds.models.model;

import java.util.Objects;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.SequenceGenerator;
import jakarta.persistence.Table;

@Entity // Objt/Entidade que está na memória que será persistido.
@Table(name = "REDS_DISCIPLINA") // Qual tabela fisica armazena a disciplina.

public class Disciplina {
	private Long id_disciplina ;
	private String nome_disciplina;
	
	public Disciplina() {
	}

	public Disciplina(Long id_disciplina , String nome_disciplina) {
		this.id_disciplina  = id_disciplina ;
		this.nome_disciplina = nome_disciplina;
	}
	
	@Id // Referencia o ID	
	// @GeneratedValue(strategy = GenerationType.IDENTITY)
	@GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "SEQ_REDS_DISCIPLINA") // Como o banco esta gerenciando a geração de chaves primárias
	@SequenceGenerator(sequenceName = "SEQ_REDS_DISCIPLINA", initialValue = 1, allocationSize = 1, name = "SEQ_REDS_DISCIPLINA")
	@Column(name = "id_disciplina ")

	public Long getIdDisciplina() {
		return id_disciplina ;
	}

	public void setIdDisciplina(Long idDisciplina) {
		this.id_disciplina  = idDisciplina;
	}
	
	@Column(name = "NOME_DISCIPLINA")

	public String getNomeDisciplina() {
		return nome_disciplina;
	}

	public void setNomeDisciplina(String nome_disciplina) {
		this.nome_disciplina = nome_disciplina;
	}

	@Override
	public int hashCode() {
		return Objects.hash(id_disciplina);
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Disciplina other = (Disciplina) obj;
		return Objects.equals(id_disciplina, other.id_disciplina);
	}

	@Override
	public String toString() {
		return "Disciplina [id_disciplina =" + id_disciplina  + ", nome_disciplina=" + nome_disciplina + "]";
	}	
}
