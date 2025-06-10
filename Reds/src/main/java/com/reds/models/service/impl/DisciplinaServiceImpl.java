package com.reds.models.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.reds.models.repository.DisciplinaRepository;
import com.reds.models.service.DisciplinaService;
import com.reds.models.service.dto.request.DisciplinaRequest;
import com.reds.models.service.dto.response.DisciplinaResponse;
import com.reds.models.service.dto.Converter.DisciplinaConverter;
import com.reds.models.service.exception.EntityNotFoundException;

@Service
@Transactional
public class DisciplinaServiceImpl implements DisciplinaService {

    @Autowired
    private DisciplinaRepository disciplinaRepository;

    @Override
    public DisciplinaResponse save(DisciplinaRequest entity) {
        
    	var disciplina = DisciplinaConverter.toDisciplina(entity);
        disciplina = disciplinaRepository.saveAndFlush(disciplina);
        
        return DisciplinaConverter.toDisciplinaResponse(disciplina);
    }

    @Override
    public DisciplinaResponse update(Long id, DisciplinaRequest entity) {
        var disciplina = disciplinaRepository.findById(id)
            .orElseThrow(() -> new EntityNotFoundException(
                String.format("Disciplina não localizada %s", String.valueOf(id))));

        disciplina.setNomeDisciplina(entity.getNome_Disciplina());
        disciplina = disciplinaRepository.saveAndFlush(disciplina);
        
        return DisciplinaConverter.toDisciplinaResponse(disciplina);
    }

    @Override
    public void deleteById(Long id) {
        disciplinaRepository.deleteById(id);
    }

    @Override
    @Transactional(readOnly = true)
    public DisciplinaResponse findById(Long id) {
        var disciplina = disciplinaRepository.findById(id)
            .orElseThrow(() -> new EntityNotFoundException(
                String.format("Disciplina não localizada %s", String.valueOf(id))));
        
        return DisciplinaConverter.toDisciplinaResponse(disciplina);
    }

    @Override
    public List<DisciplinaResponse> listar() {
    	
        var lista = disciplinaRepository.findAll();
        
        return DisciplinaConverter.toListDisciplinaResponse(lista);
    }
}