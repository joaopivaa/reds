package com.reds.models.service.dto.Converter;

import java.util.ArrayList;
import java.util.List;

import com.reds.models.model.Jogador;
import com.reds.models.model.Sala;
import com.reds.models.model.Usuario;
import com.reds.models.service.dto.request.JogadorRequest;
import com.reds.models.service.dto.response.JogadorResponse;

public class JogadorConverter {

    public static Jogador toJogador(JogadorRequest request, Usuario usuario, Sala sala) {
        return new Jogador(
            request.getNome_Jogador(),
            request.getPontuacao(),
            usuario, 
            sala
        );
    }

    public static JogadorResponse toJogadorResponse(Jogador jogador) {
        return new JogadorResponse(
            jogador.getId_jogador(),
            jogador.getNome_jogador(),
            jogador.getpontuacao(),
            jogador.getUsuario().getIdUsuario(),
            jogador.getSala().getId_sala()
        );
    }

    public static List<JogadorResponse> toListJogadorResponse(List<Jogador> listaJogadores) {
        List<JogadorResponse> listaResponse = new ArrayList<>();

        for (Jogador jogador : listaJogadores) {
            listaResponse.add(toJogadorResponse(jogador));
        }

        return listaResponse;
    }
}