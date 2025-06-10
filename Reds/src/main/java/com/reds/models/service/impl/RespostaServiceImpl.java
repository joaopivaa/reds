package com.reds.models.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.reds.models.repository.RespostaRepository;
import com.reds.models.service.RespostaService;
import com.reds.models.service.dto.request.RespostaRequest;
import com.reds.models.service.dto.response.RespostaResponse;
import com.reds.models.service.dto.Converter.RespostaConverter;
import com.reds.models.service.exception.EntityNotFoundException;

@Service
@Transactional
public class RespostaServiceImpl implements RespostaService {

    @Autowired
    private RespostaRepository respostaRepository;

    @Override
    public RespostaResponse save(RespostaRequest entity) {
        
    	var resposta = RespostaConverter.toResposta(entity);
        resposta = respostaRepository.saveAndFlush(resposta);
        
        return RespostaConverter.toRespostaResponse(resposta);
    }

    @Override
    public RespostaResponse update(Long id, RespostaRequest entity) {
        var resposta = respostaRepository.findById(id)
            .orElseThrow(() -> new EntityNotFoundException(
                String.format("Resposta não localizada %s", String.valueOf(id))));

        resposta.setNomeResposta(entity.getNome_Resposta());
        resposta = respostaRepository.saveAndFlush(resposta);
        
        return RespostaConverter.toRespostaResponse(resposta);
    }

    @Override
    public void deleteById(Long id) {
        respostaRepository.deleteById(id);
    }

    @Override
    @Transactional(readOnly = true)
    public RespostaResponse findById(Long id) {
        var resposta = respostaRepository.findById(id)
            .orElseThrow(() -> new EntityNotFoundException(
                String.format("Resposta não localizada %s", String.valueOf(id))));
        
        return RespostaConverter.toRespostaResponse(resposta);
    }

    @Override
    public List<RespostaResponse> listar() {
    	
        var lista = respostaRepository.findAll();
        
        return RespostaConverter.toListRespostaResponse(lista);
    }
}