package com.reds.models.repository;

import java.util.List;
import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import com.reds.models.model.Jogador;

public interface JogadorRepository extends JpaRepository<Jogador, Long> {

    List<Jogador> findBySalaId(Long idSala);

    Optional<Jogador> findByUsuarioIdAndSalaId(Long idUsuario, Long idSala);

    @Query("SELECT j FROM Jogador j WHERE j.usuario.id = :idUsuario")
    List<Jogador> buscarPorUsuario(@Param("idUsuario") Long idUsuario);
    
    @Query("SELECT j FROM Jogador j WHERE j.sala.id = :idSala")
    List<Jogador> buscarJogadoresPorSala(@Param("idSala") Long idSala);

}
