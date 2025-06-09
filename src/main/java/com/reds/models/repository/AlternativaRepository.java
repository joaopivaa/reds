package com.reds.models.repository;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import com.reds.models.model.Alternativa;

public interface AlternativaRepository extends JpaRepository<Alternativa, Long> {
	
	@Query(value="SELECT a FROM ALTERNATIVA a LEFT JOIN PERGUNTA p WHERE a.idPergunta =: p.idPergunta")
	Optional<Alternativa> findAlternativaById(@Param("id_Pergunta") Long id_Pergunta);
}
