package com.reds.models.model;

import java.util.Objects;

import jakarta.persistence.Entity;
import jakarta.persistence.FetchType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.MapsId;
import jakarta.persistence.OneToOne;
import jakarta.persistence.Table;

@Entity // Objt/Entidade que está na memória que será persistido.
@Table(name = "REDS_SALA_PERGUNTA") // Qual tabela fisica armazena a sala_pergunta.

public class Sala_Pergunta {
	private Pergunta pergunta;
	private Sala sala;
	
	public Sala_Pergunta() {
		
	}
	
	public Sala_Pergunta(Pergunta pergunta, Sala sala) {
		this.pergunta = pergunta;
		this.sala = sala;
	}
	@Id
	@MapsId
	@OneToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "id_pergunta",referencedColumnName = "id_pergunta")
	public Pergunta getPergunta() {
		return pergunta;
	}

	public void setPergunta(Pergunta pergunta) {
		this.pergunta = pergunta;
	}
	@Id
	@MapsId
	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "id_sala",referencedColumnName = "id_sala")
	public Sala getSala() {
		return sala;
	}

	public void setSala(Sala sala) {
		this.sala = sala;
	}

	@Override
	public int hashCode() {
		return Objects.hash(pergunta, sala);
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Sala_Pergunta other = (Sala_Pergunta) obj;
		return Objects.equals(pergunta, other.pergunta) && Objects.equals(sala, other.sala);
	}

	@Override
	public String toString() {
		return "Sala_Pergunta [pergunta=" + pergunta + ", sala=" + sala + "]";
	}
	
	
}
