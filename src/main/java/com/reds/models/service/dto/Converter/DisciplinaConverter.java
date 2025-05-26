package com.reds.models.service.dto.Converter;

import java.util.ArrayList;
import java.util.List;

import com.reds.models.model.Disciplina;
import com.reds.models.service.dto.request.DisciplinaRequest;
import com.reds.models.service.dto.response.DisciplinaResponse;

public class DisciplinaConverter {
	
	public static Disciplina toDisciplina(DisciplinaRequest disciplinaRequest) {
		return new Disciplina(
			disciplinaRequest.getNome_Disciplina()
		);
	}
	
	public static List<DisciplinaResponse> toListDisciplinaResponse(List<Disciplina> listaDisciplina){
		List<DisciplinaResponse> listarDisciplinaResponse = new ArrayList<DisciplinaResponse>();
		
		for (Disciplina disciplina : listaDisciplina) {
			DisciplinaResponse disciplinaResponse = toDisciplinaResponse(disciplina);
			listarDisciplinaResponse.add(disciplinaResponse);
		}
		return listarDisciplinaResponse;
	}
	public static DisciplinaResponse toDisciplinaResponse(Disciplina disciplina) {
		return new DisciplinaResponse(
				disciplina.getIdDisciplina(),
				disciplina.getNomeDisciplina()
			);
	}
}
