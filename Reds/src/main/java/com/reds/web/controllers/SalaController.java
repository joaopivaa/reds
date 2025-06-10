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

import com.reds.models.service.SalaService;
import com.reds.models.service.dto.request.SalaRequest;
import com.reds.web.response.MensagemSistema;

import jakarta.servlet.http.HttpServletRequest;
import jakarta.validation.Valid;

public class SalaController {
	
	private SalaService salaService;
	
	@GetMapping(value="/listar")
	public ResponseEntity<?> listar(HttpServletRequest request) {
		var response = salaService.listar();
		return MensagemSistema.showMensagem(
			"Lista Processada",
			HttpStatus.OK,
			response,
			request
		);
	}
	
	@PostMapping(value = "/salvar", consumes = MediaType.APPLICATION_JSON_VALUE)
	public ResponseEntity<?> save(@RequestBody @Valid SalaRequest salaRequest, HttpServletRequest request) {
		var response = salaService.save(salaRequest);
		return MensagemSistema.showMensagem(
			"Alternativa registrada com sucesso",
			HttpStatus.CREATED,
			response,
			request
		);
	}
	
	@PutMapping(value = "/alterar/{id}", consumes = MediaType.APPLICATION_JSON_VALUE)
	public ResponseEntity<?> update(@PathVariable Long id, @RequestBody @Valid SalaRequest salaRequest, HttpServletRequest request) {
		var response = salaService.update(id, salaRequest);
		return MensagemSistema.showMensagem(
			"Alternativa alterada com sucesso",
			HttpStatus.OK,
			response,
			request
		);
	}

	@GetMapping(value = "/buscar/{id}")
	public ResponseEntity<?> findById(@PathVariable Long id, HttpServletRequest request) {
		var response = salaService.findById(id);
		return MensagemSistema.showMensagem(
			"Alternativa localizada com sucesso",
			HttpStatus.OK,
			response,
			request
		);
	}

	@DeleteMapping(value = "/excluir/{id}")
	public ResponseEntity<?> deleteById(@PathVariable Long id, HttpServletRequest request) {
		salaService.deleteById(id);
		return MensagemSistema.showMensagem(
			"Alternativa excluída com sucesso",
			HttpStatus.NO_CONTENT,
			request
		);
	}

}
