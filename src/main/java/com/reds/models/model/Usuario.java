package com.reds.models.model;

import java.util.Objects;
import java.util.Set;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.OneToMany;
import jakarta.persistence.SequenceGenerator;
import jakarta.persistence.Table;

@Entity // Objt/Entidade que está na memória que será persistido.
@Table(name = "REDS_USUARIO") // Qual tabela fisica armazena o usuario.
public class Usuario {
	
	private Long id_usuario;
	private String nome_usuario;
	private String email;
	private String senha;
	private Long salas_jogadas;
	private Long vitorias;
	
	private Set<UsuarioRolePermission> usuario;
	
	
	public Usuario(String nome_usuario, String email) {
		this.nome_usuario = nome_usuario;
		this.email = email;
	}
	
	@Id // Referencia o ID	
	// @GeneratedValue(strategy = GenerationType.IDENTITY)
	@GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "SEQ_REDS_USUARIO") // Como o banco esta gerenciando a geração de chaves primárias
	@SequenceGenerator(sequenceName = "SEQ_REDS_USUARIO", initialValue = 1, allocationSize = 1, name = "SEQ_REDS_USUARIO")
	@Column(name = "id_usuario")
	
	public Long getIdUsuario() {
		return id_usuario;
	}

	public void setIdUsuario(Long id_usuario) {
		this.id_usuario = id_usuario;
	}

	@OneToMany(mappedBy = "usuario")
	public Set<UsuarioRolePermission> getUsuario() {
		return usuario;
	}

	public void setUsuario(Set<UsuarioRolePermission> usuario) {
		this.usuario = usuario;
	}

	@Column(name = "nome_usuario")

	public String getNomeUsuario() {
		return nome_usuario;
	}

	public void setNomeUsuario(String nome_usuario) {
		this.nome_usuario = nome_usuario;
	}
	
	@Column(name = "email")

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}
	

	@Column(name = "senha")

	public String getSenha() {
		return senha;
	}

	public void setSenha(String senha) {
		this.senha = senha;
	}
	
	@Column(name = "salas_jogadas")

	public Long getSalas_jogadas() {
		return salas_jogadas;
	}

	public void setSalas_jogadas(Long salas_jogadas) {
		this.salas_jogadas = salas_jogadas;
	}

	@Column(name = "vitorias")
	
	public Long getVitorias() {
		return vitorias;
	}

	public void setVitorias(Long vitorias) {
		this.vitorias = vitorias;
	}

	@Override
	public int hashCode() {
		return Objects.hash(id_usuario);
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Usuario other = (Usuario) obj;
		return Objects.equals(id_usuario, other.id_usuario);
	}

	@Override
	public String toString() {
		return "Usuario [id_usuario=" + id_usuario + ", nome_usuario=" + nome_usuario + ", email=" + email + ", senha="
				+ senha + ", salas_jogadas=" + salas_jogadas + ", vitorias=" + vitorias + ", usuario=" + usuario + "]";
	}

}
