package com.reds.models.service.dto.Converter;

import java.util.ArrayList;
import java.util.List;

import com.reds.models.model.Disciplina;
import com.reds.models.model.Pergunta;
import com.reds.models.service.dto.request.PerguntaRequest;
import com.reds.models.service.dto.response.PerguntaResponse;

public class PerguntaConverter {

    public static Pergunta toPergunta(PerguntaRequest request, Disciplina disciplina) {
        return new Pergunta(
            request.getEnunciado(),
            request.getTipo(),
            disciplina
        );
    }

    public static PerguntaResponse toPerguntaResponse(Pergunta pergunta) {
        return new PerguntaResponse(
            pergunta.getId_pergunta(),
            pergunta.getEnunciado(),
            pergunta.getTipo(),
            pergunta.getDisciplina().getIdDisciplina()
        );
    }

    public static List<PerguntaResponse> toPerguntaResponseList(List<Pergunta> lista) {
        List<PerguntaResponse> resposta = new ArrayList<>();
        for (Pergunta p : lista) {
            resposta.add(toPerguntaResponse(p));
        }
        return resposta;
    }
}