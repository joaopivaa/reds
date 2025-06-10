package com.reds.models.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import com.reds.models.model.Resposta;

public interface RespostaRepository extends JpaRepository<Resposta, Long> {
	List<Resposta> findByJogadorId(Long idJogador);

    List<Resposta> findByPerguntaId(Long idPergunta);

    List<Resposta> findByJogadorIdAndPerguntaId(Long idJogador, Long idPergunta);

    @Query("SELECT r FROM Resposta r WHERE r.jogador.id = :idJogador AND r.correta = 'S'")
    List<Resposta> findRespostasCorretasPorJogador(@Param("idJogador") Long idJogador);
}
