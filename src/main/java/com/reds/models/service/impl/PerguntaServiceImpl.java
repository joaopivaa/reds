package com.reds.models.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.reds.models.repository.PerguntaRepository;
import com.reds.models.service.PerguntaService;
import com.reds.models.service.dto.request.PerguntaRequest;
import com.reds.models.service.dto.response.PerguntaResponse;
import com.reds.models.service.dto.Converter.PerguntaConverter;
import com.reds.models.service.exception.EntityNotFoundException;

@Service
@Transactional
public class PerguntaServiceImpl implements PerguntaService {

    @Autowired
    private PerguntaRepository salaRepository;

    @Override
    public PerguntaResponse save(PerguntaRequest entity) {
        
    	var sala = PerguntaConverter.toPergunta(entity);
        sala = salaRepository.saveAndFlush(sala);
        
        return PerguntaConverter.toPerguntaResponse(sala);
    }

    @Override
    public PerguntaResponse update(Long id, PerguntaRequest entity) {
        var sala = salaRepository.findById(id)
            .orElseThrow(() -> new EntityNotFoundException(
                String.format("Pergunta não localizada %s", String.valueOf(id))));

        sala.setNomePergunta(entity.getNome_Pergunta());
        sala = salaRepository.saveAndFlush(sala);
        
        return PerguntaConverter.toPerguntaResponse(sala);
    }

    @Override
    public void deleteById(Long id) {
        salaRepository.deleteById(id);
    }

    @Override
    @Transactional(readOnly = true)
    public PerguntaResponse findById(Long id) {
        var sala = salaRepository.findById(id)
            .orElseThrow(() -> new EntityNotFoundException(
                String.format("Pergunta não localizada %s", String.valueOf(id))));
        
        return PerguntaConverter.toPerguntaResponse(sala);
    }

    @Override
    public List<PerguntaResponse> listar() {
    	
        var lista = salaRepository.findAll();
        
        return PerguntaConverter.toListPerguntaResponse(lista);
    }
}