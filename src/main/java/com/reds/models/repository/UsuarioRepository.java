package com.reds.models.repository;

import java.util.List;
import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import com.reds.models.model.Usuario;
import com.reds.models.repository.projection.UsuarioCidadeProjection;
																			// <?> classe genérica, qualquer dado
public interface UsuarioRepository extends JpaRepository<Usuario, Long> { 	// <> classe genérica (passo um dado), 
																			// trabalha com qualquer tipo de dado
	
	@Query(
			"SELECT " + 
					"u.idUsuario AS idUsuario, " +
					"u.nomeUsuario AS nomeUsuario, " +
					"u.email AS email, " +
					"FROM REDS_USUARIO u "
	)
	List<UsuarioCidadeProjection> listagemUsuario();
	
	@Query(value="SELECT u FROM Usuario u WHERE u.email =: email")
	Optional<Usuario> findUsuarioByEmail(@Param("email") String email);
}
