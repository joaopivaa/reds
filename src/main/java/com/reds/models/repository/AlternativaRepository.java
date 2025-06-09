package com.reds.models.repository;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import com.reds.models.model.Alternativa;

public interface AlternativaRepository extends JpaRepository<Alternativa, Long> {
	
	@Query("SELECT a FROM Alternativa a LEFT JOIN a.pergunta p WHERE p.id = :idPergunta")
	Optional<Alternativa> findAlternativaById(@Param("idPergunta") Long idPergunta);
}
