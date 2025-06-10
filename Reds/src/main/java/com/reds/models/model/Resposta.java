package com.reds.models.model;

import java.time.LocalDateTime;
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
@Table(name = "REDS_RESPOSTA") // Qual tabela fisica armazena a sala.
public class Resposta {
	private Long id_resposta;
	private LocalDateTime tempoResposta;
	private String correta;
	private Jogador jogador;
	private Pergunta pergunta;
	private Alternativa alternativa;
	
	public Resposta() {
		
	}

	public Resposta(Long id_resposta, LocalDateTime tempoResposta, String correta, Jogador jogador, Pergunta pergunta,
			Alternativa alternativa) {
		this.id_resposta = id_resposta;
		this.tempoResposta = tempoResposta;
		this.correta = correta;
		this.jogador = jogador;
		this.pergunta = pergunta;
		this.alternativa = alternativa;
	}
	@Id // Referencia o ID	
	// @GeneratedValue(strategy = GenerationType.IDENTITY)
	@GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "SEQ_REDS_RESPOSTA") // Como o banco esta gerenciando a geração de chaves primárias
	@SequenceGenerator(sequenceName = "SEQ_REDS_RESPOSTA", initialValue = 1, allocationSize = 1, name = "SEQ_REDS_RESPOSTA")
	@Column(name = "id_resposta")
	public Long getId_resposta() {
		return id_resposta;
	}

	public void setId_resposta(Long id_resposta) {
		this.id_resposta = id_resposta;
	}
	@Column(name = "tempo_resposta", columnDefinition = "TIMESTAMP DEFAULT CURRENT_TIMESTAMP")
	public LocalDateTime getTempoResposta() {
		return tempoResposta;
	}

	public void setTempoResposta(LocalDateTime tempoResposta) {
		this.tempoResposta = tempoResposta;
	}
	@Column(name = "correta")
	public String getCorreta() {
		return correta;
	}

	public void setCorreta(String correta) {
		this.correta = correta;
	}
	@OneToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "id_jogador", referencedColumnName = "id_jogador")
	public Jogador getJogador() {
		return jogador;
	}

	public void setJogador(Jogador jogador) {
		this.jogador = jogador;
	}
	@OneToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "id_pergunta",referencedColumnName = "id_pergunta")
	public Pergunta getPergunta() {
		return pergunta;
	}

	public void setPergunta(Pergunta pergunta) {
		this.pergunta = pergunta;
	}
	@OneToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "id_alternativa", referencedColumnName = "id_alternativa")
	public Alternativa getAlternativa() {
		return alternativa;
	}

	public void setAlternativa(Alternativa alternativa) {
		this.alternativa = alternativa;
	}
	
	@Override
	public int hashCode() {
		return Objects.hash(id_resposta);
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Resposta other = (Resposta) obj;
		return Objects.equals(id_resposta, other.id_resposta);
	}

	@Override
	public String toString() {
		return "Resposta [id_resposta=" + id_resposta + ", tempoResposta=" + tempoResposta + ", correta=" + correta
				+ ", jogador=" + jogador + ", pergunta=" + pergunta + ", alternativa=" + alternativa + "]";
	}
	
}
