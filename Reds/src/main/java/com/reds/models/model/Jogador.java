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
import jakarta.persistence.OneToOne;
import jakarta.persistence.SequenceGenerator;
import jakarta.persistence.Table;

@Entity // Objt/Entidade que está na memória que será persistido.
@Table(name = "REDS_JOGADOR") // Qual tabela fisica armazena o jogador.
public class Jogador {
	private Long id_jogador;
	private String nome_jogador;
	private Long pontuacao;
	
	private Usuario usuario;
	private Sala sala;
	
	public Jogador() {
		
	}
	
	public Jogador(Long id_jogador, String nome_jogador, Long pontuacao, Usuario usuario, Sala sala) {
		this.id_jogador = id_jogador;
		this.nome_jogador = nome_jogador;
		this.pontuacao = pontuacao;
		this.usuario = usuario;
		this.sala = sala;
	}
	@Id // Referencia o ID	
	// @GeneratedValue(strategy = GenerationType.IDENTITY)
	@GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "SEQ_REDS_JOGADOR") // Como o banco esta gerenciando a geração de chaves primárias
	@SequenceGenerator(sequenceName = "SEQ_REDS_JOGADOR", initialValue = 1, allocationSize = 1, name = "SEQ_REDS_JOGADOR")
	@Column(name = "id_jogador") 
	public Long getId_jogador() {
		return id_jogador;
	}

	public void setId_jogador(Long id_jogador) {
		this.id_jogador = id_jogador;
	}
	@Column(name = "nome_jogador")
	public String getNome_jogador() {
		return nome_jogador;
	}

	public void setNome_jogador(String nome_jogador) {
		this.nome_jogador = nome_jogador;
	}
	@Column(name = "pontuacao")
	public Long getpontuacao() {
		return pontuacao;
	}

	public void setpontuacao(Long pontuacao) {
		this.pontuacao = pontuacao;
	}
	
	@OneToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "id_usuario", referencedColumnName = "id_usuario")
	public Usuario getUsuario() {
		return usuario;
	}

	public void setUsuario(Usuario usuario) {
		this.usuario = usuario;
	}
	
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
		return Objects.hash(id_jogador);
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Jogador other = (Jogador) obj;
		return Objects.equals(id_jogador, other.id_jogador);
	}

	@Override
	public String toString() {
		return "Jogador [id_jogador=" + id_jogador + ", nome_jogador=" + nome_jogador + ", pontuacao=" + pontuacao
				+ ", usuario=" + usuario + ", sala=" + sala + "]";
	}
	
	
}
