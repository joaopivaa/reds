package com.reds.models.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import com.reds.models.model.Sala_Pergunta;

public interface Sala_PerguntaRepository extends JpaRepository<Sala_Pergunta, Long> {
	
	@Query("SELECT sp FROM Sala_Pergunta sp WHERE sp.sala.id = :idSala")
	List<Sala_Pergunta> buscarPorSala(@Param("idSala") Long idSala);

}
