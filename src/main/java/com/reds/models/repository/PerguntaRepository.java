package com.reds.models.repository;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import com.reds.models.model.Pergunta;

public interface PerguntaRepository extends JpaRepository<Pergunta, Long> {
	
	// trabalha com qualquer tipo de dado
		
	@Query(value="SELECT p FROM PERGUNTA d WHERE p.enunciado =: enunciado")
	Optional<Pergunta> findPerguntaByEnunciado(@Param("enunciado") String enunciado);

}
