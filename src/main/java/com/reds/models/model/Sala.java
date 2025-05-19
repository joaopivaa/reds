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
@Table(name = "REDS_SALA") // Qual tabela fisica armazena a sala.
public class Sala {
	private Long id_sala;
	private String codigo;
	private Long numero_jogadores;
	private Long qtd_perguntas;
	private Long tempo_limite;
	
	private Usuario criador;
	private Disciplina disciplina;
	
	public Sala() {
		
	}

	public Sala(Long id_sala, String codigo, Long numero_jogadores, Long qtd_perguntas, Long tempo_limite,
			Usuario criador, Disciplina disciplina) {
		this.id_sala = id_sala;
		this.codigo = codigo;
		this.numero_jogadores = numero_jogadores;
		this.qtd_perguntas = qtd_perguntas;
		this.tempo_limite = tempo_limite;
		this.criador = criador;
		this.disciplina = disciplina;
	}
	
	@Id // Referencia o ID	
	// @GeneratedValue(strategy = GenerationType.IDENTITY)
	@GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "SEQ_REDS_SALA") // Como o banco esta gerenciando a geração de chaves primárias
	@SequenceGenerator(sequenceName = "SEQ_REDS_SALA", initialValue = 1, allocationSize = 1, name = "SEQ_REDS_SALA")
	@Column(name = "id_sala")
	public Long getId_sala() {
		return id_sala;
	}

	public void setId_sala(Long id_sala) {
		this.id_sala = id_sala;
	}
	@Column(name = "codigo")
	public String getCodigo() {
		return codigo;
	}

	public void setCodigo(String codigo) {
		this.codigo = codigo;
	}
	@Column(name = "numero_jogadores")
	public Long getNumero_jogadores() {
		return numero_jogadores;
	}

	public void setNumero_jogadores(Long numero_jogadores) {
		this.numero_jogadores = numero_jogadores;
	}
	@Column(name = "qtd_perguntas")
	public Long getQtd_perguntas() {
		return qtd_perguntas;
	}

	public void setQtd_perguntas(Long qtd_perguntas) {
		this.qtd_perguntas = qtd_perguntas;
	}
	@Column(name = "tempo_limite")
	public Long getTempo_limite() {
		return tempo_limite;
	}

	public void setTempo_limite(Long tempo_limite) {
		this.tempo_limite = tempo_limite;
	}
	@ManyToOne(fetch = FetchType.LAZY) 
	@JoinColumn(name = "id_criador", referencedColumnName = "id_usuario") 
	public Usuario getCriador() {
		return criador;
	}
	
	public void setCriador(Usuario criador) {
		this.criador = criador;
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
		return Objects.hash(id_sala);
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Sala other = (Sala) obj;
		return Objects.equals(id_sala, other.id_sala);
	}

	@Override
	public String toString() {
		return "Sala [id_sala=" + id_sala + ", codigo=" + codigo + ", numero_jogadores=" + numero_jogadores
				+ ", qtd_perguntas=" + qtd_perguntas + ", tempo_limite=" + tempo_limite + ", criador=" + criador
				+ ", disciplina=" + disciplina + "]";
	}
	
	
}
