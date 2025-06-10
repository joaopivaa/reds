package com.reds.models.service.dto.Converter;

import java.util.ArrayList;
import java.util.List;

import com.reds.models.model.Disciplina;
import com.reds.models.model.Sala;
import com.reds.models.model.Usuario;
import com.reds.models.service.dto.request.SalaRequest;
import com.reds.models.service.dto.response.SalaResponse;

public class SalaConverter {

    public static Sala toSala(SalaRequest request, Usuario criador, Disciplina disciplina) {
        return new Sala(
            request.getCodigo(),
            request.getNumero_Jogadores(),
            request.getQtd_Perguntas(),
            request.getTempo_Limite(),
            criador,
            disciplina
        );
    }

    public static SalaResponse toSalaResponse(Sala sala) {
        return new SalaResponse(
            sala.getId_sala(),
            sala.getCodigo(),
            sala.getNumero_jogadores(),
            sala.getQtd_perguntas(),
            sala.getTempo_limite(),
            sala.getCriador().getIdUsuario(),
            sala.getDisciplina().getIdDisciplina()
        );
    }

    public static List<SalaResponse> toSalaResponseList(List<Sala> lista) {
        List<SalaResponse> resposta = new ArrayList<>();
        for (Sala sala : lista) {
            resposta.add(toSalaResponse(sala));
        }
        return resposta;
    }
}