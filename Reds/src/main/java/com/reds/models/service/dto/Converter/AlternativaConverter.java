package com.reds.models.service.dto.Converter;

import java.util.ArrayList;
import java.util.List;

import com.reds.models.model.Alternativa;
import com.reds.models.model.Pergunta;
import com.reds.models.service.dto.request.AlternativaRequest;
import com.reds.models.service.dto.response.AlternativaResponse;

public class AlternativaConverter {

    public static Alternativa toAlternativa(AlternativaRequest request, Pergunta pergunta) {
        return new Alternativa(
            request.getTexto(),
            request.getCorreta(),
            pergunta
        );
    }

    public static AlternativaResponse toAlternativaResponse(Alternativa alt) {
        return new AlternativaResponse(
            alt.getId_Alternativa(),
            alt.getTexto(),
            alt.getCorreta(),
            alt.getPergunta().getId_pergunta()
        );
    }

    public static List<AlternativaResponse> toAlternativaResponseList(List<Alternativa> lista) {
        List<AlternativaResponse> resposta = new ArrayList<>();
        for (Alternativa alt : lista) {
            resposta.add(toAlternativaResponse(alt));
        }
        return resposta;
    }
}