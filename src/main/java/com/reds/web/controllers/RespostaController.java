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

import com.reds.models.service.RespostaService;
import com.reds.models.service.dto.request.RespostaRequest;
import com.reds.web.response.MensagemSistema;

import jakarta.servlet.http.HttpServletRequest;
import jakarta.validation.Valid;

public class RespostaController {

	private RespostaService respostaService;
	
	@GetMapping(value="/listar")
	public ResponseEntity<?> listar(HttpServletRequest request) {
		var response = respostaService.listar();
		return MensagemSistema.showMensagem(
			"Lista Processada",
			HttpStatus.OK,
			response,
			request
		);
	}
	
	@PostMapping(value = "/salvar", consumes = MediaType.APPLICATION_JSON_VALUE)
	public ResponseEntity<?> save(@RequestBody @Valid RespostaRequest respostaRequest, HttpServletRequest request) {
		var response = respostaService.save(respostaRequest);
		return MensagemSistema.showMensagem(
			"Alternativa registrada com sucesso",
			HttpStatus.CREATED,
			response,
			request
		);
	}
	
	@PutMapping(value = "/alterar/{id}", consumes = MediaType.APPLICATION_JSON_VALUE)
	public ResponseEntity<?> update(@PathVariable Long id, @RequestBody @Valid RespostaRequest respostaRequest, HttpServletRequest request) {
		var response = respostaService.update(id, respostaRequest);
		return MensagemSistema.showMensagem(
			"Alternativa alterada com sucesso",
			HttpStatus.OK,
			response,
			request
		);
	}

	@GetMapping(value = "/buscar/{id}")
	public ResponseEntity<?> findById(@PathVariable Long id, HttpServletRequest request) {
		var response = respostaService.findById(id);
		return MensagemSistema.showMensagem(
			"Alternativa localizada com sucesso",
			HttpStatus.OK,
			response,
			request
		);
	}

	@DeleteMapping(value = "/excluir/{id}")
	public ResponseEntity<?> deleteById(@PathVariable Long id, HttpServletRequest request) {
		respostaService.deleteById(id);
		return MensagemSistema.showMensagem(
			"Alternativa excluída com sucesso",
			HttpStatus.NO_CONTENT,
			request
		);
	}
}
