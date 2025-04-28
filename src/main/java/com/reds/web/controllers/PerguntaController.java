package com.reds.web.controllers;

import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.reds.models.service.PerguntaService;
import com.reds.models.service.dto.request.PerguntaRequest;
import com.reds.web.response.MensagemSistema;

import jakarta.servlet.http.HttpServletRequest;
import jakarta.validation.Valid;

@RestController
@RequestMapping(value = "/rest/Pergunta")
public class PerguntaController {

	private PerguntaService perguntaService;
	
	@GetMapping(value="/listar")
	public ResponseEntity<?> listar(HttpServletRequest request) {
		var response = perguntaService.listar();
		return MensagemSistema.showMensagem(
			"Lista Processada",
			HttpStatus.OK,
			response,
			request
		);
	}
	
	@PostMapping(value = "/salvar", consumes = MediaType.APPLICATION_JSON_VALUE)
	public ResponseEntity<?> save(@RequestBody @Valid PerguntaRequest perguntaRequest, HttpServletRequest request) {
		var response = perguntaService.save(perguntaRequest);
		return MensagemSistema.showMensagem(
			"Disciplina registrada com sucesso",
			HttpStatus.CREATED,
			response,
			request
		);
	}
	
	@PutMapping(value = "/alterar/{id}", consumes = MediaType.APPLICATION_JSON_VALUE)
	public ResponseEntity<?> update(@PathVariable Long id, @RequestBody @Valid PerguntaRequest perguntaRequest, HttpServletRequest request) {
		var response = perguntaService.update(id, perguntaRequest);
		return MensagemSistema.showMensagem(
			"Disciplina alterada com sucesso",
			HttpStatus.OK,
			response,
			request
		);
	}

	@GetMapping(value = "/buscar/{id}")
	public ResponseEntity<?> findById(@PathVariable Long id, HttpServletRequest request) {
		var response = perguntaService.findById(id);
		return MensagemSistema.showMensagem(
			"Disciplina localizada com sucesso",
			HttpStatus.OK,
			response,
			request
		);
	}

	@DeleteMapping(value = "/excluir/{id}")
	public ResponseEntity<?> deleteById(@PathVariable Long id, HttpServletRequest request) {
		perguntaService.deleteById(id);
		return MensagemSistema.showMensagem(
			"Disciplina excluída com sucesso",
			HttpStatus.NO_CONTENT,
			request
		);
	}
}
