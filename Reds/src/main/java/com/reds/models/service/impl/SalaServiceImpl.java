package com.reds.models.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.reds.models.repository.SalaRepository;
import com.reds.models.service.SalaService;
import com.reds.models.service.dto.request.SalaRequest;
import com.reds.models.service.dto.response.SalaResponse;
import com.reds.models.service.dto.Converter.SalaConverter;
import com.reds.models.service.exception.EntityNotFoundException;

@Service
@Transactional
public class SalaServiceImpl implements SalaService {

    @Autowired
    private SalaRepository salaRepository;

    @Override
    public SalaResponse save(SalaRequest entity) {
        
    	var sala = SalaConverter.toSala(entity);
        sala = salaRepository.saveAndFlush(sala);
        
        return SalaConverter.toSalaResponse(sala);
    }

    @Override
    public SalaResponse update(Long id, SalaRequest entity) {
        var sala = salaRepository.findById(id)
            .orElseThrow(() -> new EntityNotFoundException(
                String.format("Sala não localizada %s", String.valueOf(id))));

        sala.setNomeSala(entity.getNome_Sala());
        sala = salaRepository.saveAndFlush(sala);
        
        return SalaConverter.toSalaResponse(sala);
    }

    @Override
    public void deleteById(Long id) {
        salaRepository.deleteById(id);
    }

    @Override
    @Transactional(readOnly = true)
    public SalaResponse findById(Long id) {
        var sala = salaRepository.findById(id)
            .orElseThrow(() -> new EntityNotFoundException(
                String.format("Sala não localizada %s", String.valueOf(id))));
        
        return SalaConverter.toSalaResponse(sala);
    }

    @Override
    public List<SalaResponse> listar() {
    	
        var lista = salaRepository.findAll();
        
        return SalaConverter.toListSalaResponse(lista);
    }
}