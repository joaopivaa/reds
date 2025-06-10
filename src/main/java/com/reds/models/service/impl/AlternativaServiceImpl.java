package com.reds.models.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.reds.models.repository.AlternativaRepository;
import com.reds.models.service.AlternativaService;
import com.reds.models.service.dto.request.AlternativaRequest;
import com.reds.models.service.dto.response.AlternativaResponse;
import com.reds.models.service.dto.Converter.AlternativaConverter;
import com.reds.models.service.exception.EntityNotFoundException;

@Service
@Transactional
public class AlternativaServiceImpl implements AlternativaService {

    @Autowired
    private AlternativaRepository alternativaRepository;

    @Override
    public AlternativaResponse save(AlternativaRequest entity) {
        
    	var alternativa = AlternativaConverter.toAlternativa(entity);
        alternativa = alternativaRepository.saveAndFlush(alternativa);
        
        return AlternativaConverter.toAlternativaResponse(alternativa);
    }

    @Override
    public AlternativaResponse update(Long id, AlternativaRequest entity) {
        var alternativa = alternativaRepository.findById(id)
            .orElseThrow(() -> new EntityNotFoundException(
                String.format("Alternativa não localizada %s", String.valueOf(id))));

        alternativa.setNomeAlternativa(entity.getNome_Alternativa());
        alternativa = alternativaRepository.saveAndFlush(alternativa);
        
        return AlternativaConverter.toAlternativaResponse(alternativa);
    }

    @Override
    public void deleteById(Long id) {
        alternativaRepository.deleteById(id);
    }

    @Override
    @Transactional(readOnly = true)
    public AlternativaResponse findById(Long id) {
        var alternativa = alternativaRepository.findById(id)
            .orElseThrow(() -> new EntityNotFoundException(
                String.format("Alternativa não localizada %s", String.valueOf(id))));
        
        return AlternativaConverter.toAlternativaResponse(alternativa);
    }

    @Override
    public List<AlternativaResponse> listar() {
    	
        var lista = alternativaRepository.findAll();
        
        return AlternativaConverter.toListAlternativaResponse(lista);
    }
}