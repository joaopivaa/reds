package com.reds.models.repository;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import com.reds.models.model.Disciplina;
import com.reds.models.model.Usuario;

public interface DisciplinaRepository extends JpaRepository<Disciplina,Long> {
	
	@Query(value="SELECT d FROM DISCIPLINA d WHERE d.nome_disciplina =: nome_disciplina")
	Optional<Usuario> findDisciplinaByNome(@Param("nome_disciplina") String nome_disciplina);
	
}
