package com.reds.models.repository;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import com.reds.models.model.Sala;
import com.reds.models.model.Usuario;

public interface SalaRepository extends JpaRepository<Sala, Long>{
	
	@Query("SELECT s FROM Sala s WHERE s.disciplina.nome = :nome_disciplina")
	Optional<Sala> findSalaByNomeDisciplina(@Param("nome_disciplina") String nome_disciplina);
	
	@Query("SELECT s FROM Sala s WHERE s.criador.id = :idCriador")
	Optional<Usuario> findByCriadorId(@Param("idCriador") Long idCriador);
}
