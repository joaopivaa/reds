package com.reds.models.service.dto.Converter;

import java.util.ArrayList;
import java.util.List;

import com.reds.models.model.Alternativa;
import com.reds.models.model.Jogador;
import com.reds.models.model.Pergunta;
import com.reds.models.model.Resposta;
import com.reds.models.service.dto.request.RespostaRequest;
import com.reds.models.service.dto.response.RespostaResponse;

public class RespostaConverter {

    public static Resposta toResposta(RespostaRequest request, Jogador jogador, Pergunta pergunta, Alternativa alternativa) {
    	
    	return new Resposta(
            request.getCorreta(),
            request.getTempoResposta(),
            jogador,
            pergunta,
            alternativa
        );
    }

    public static RespostaResponse toRespostaResponse(Resposta resposta) {
        return new RespostaResponse(
            resposta.getId_resposta(),
            resposta.getTempoResposta(),
            resposta.getCorreta(),
            resposta.getJogador().getId_jogador(),
            resposta.getPergunta().getId_pergunta(),
            resposta.getAlternativa().getId_Alternativa()
        );
    }

    public static List<RespostaResponse> toRespostaResponseList(List<Resposta> lista) {
        List<RespostaResponse> resposta = new ArrayList<>();
        for (Resposta r : lista) {
            resposta.add(toRespostaResponse(r));
        }
        return resposta;
    }
}