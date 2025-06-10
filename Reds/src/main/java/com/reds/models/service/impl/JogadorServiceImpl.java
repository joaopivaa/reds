package com.reds.models.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.reds.models.repository.JogadorRepository;
import com.reds.models.service.JogadorService;
import com.reds.models.service.dto.request.JogadorRequest;
import com.reds.models.service.dto.response.JogadorResponse;
import com.reds.models.service.dto.Converter.JogadorConverter;
import com.reds.models.service.exception.EntityNotFoundException;

@Service
@Transactional
public class JogadorServiceImpl implements JogadorService {

    @Autowired
    private JogadorRepository jogadorRepository;

    @Override
    public JogadorResponse save(JogadorRequest entity) {
        var jogador = JogadorConverter.toJogador(entity);
        jogador = jogadorRepository.saveAndFlush(jogador);
        return JogadorConverter.toJogadorResponse(jogador);
    }

    @Override
    public JogadorResponse update(Long id, JogadorRequest entity) {
        var jogador = jogadorRepository.findById(id)
            .orElseThrow(() -> new EntityNotFoundException(
                String.format("Jogador não localizado %s", String.valueOf(id))));

        jogador.setNome_jogador(entity.getNome_Jogador());
        jogador = jogadorRepository.saveAndFlush(jogador);
        return JogadorConverter.toJogadorResponse(jogador);
    }

    @Override
    public void deleteById(Long id) {
        jogadorRepository.deleteById(id);
    }

    @Override
    @Transactional(readOnly = true)
    public JogadorResponse findById(Long id) {
        var jogador = jogadorRepository.findById(id)
            .orElseThrow(() -> new EntityNotFoundException(
                String.format("Jogador não localizado %s", String.valueOf(id))));
        return JogadorConverter.toJogadorResponse(jogador);
    }

    @Override
    public List<JogadorResponse> listar() {
        var lista = jogadorRepository.findAll();
        return JogadorConverter.toListJogadorResponse(lista);
    }
}
