package com.reds.web.controllers;

import org.springframework.beans.factory.annotation.Autowired;
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

import com.reds.models.service.UsuarioService;
import com.reds.models.service.dto.request.UsuarioRequest;
import com.reds.web.response.MensagemSistema;
import com.reds.web.swagger.UsuarioControllerApi;

import jakarta.servlet.http.HttpServletRequest;
import jakarta.validation.Valid;

@RestController
@RequestMapping(value = "/rest/usuario")
public class UsuarioController implements UsuarioControllerApi {
	
	@Autowired
	private UsuarioService usuarioService;
	
	@Override
	@GetMapping(value="/listar")
	public ResponseEntity<?> listar(HttpServletRequest request) {
		var response = usuarioService.listar();
		return MensagemSistema.showMensagem(
			"Lista Processada",
			HttpStatus.OK,
			response,
			request
		);
	}
	
	@Override
	@PostMapping(value = "/salvar", consumes = MediaType.APPLICATION_JSON_VALUE)
	public ResponseEntity<?> save(@RequestBody @Valid UsuarioRequest usuarioRequest, HttpServletRequest request) {
		var response = usuarioService.save(usuarioRequest);
		return MensagemSistema.showMensagem(
			"Usuário registrado com sucesso",
			HttpStatus.CREATED,
			response,
			request
		);
	}
	
	@Override
	@PutMapping(value = "/alterar/{id}", consumes = MediaType.APPLICATION_JSON_VALUE)
	public ResponseEntity<?> update(@PathVariable Long id, @RequestBody @Valid UsuarioRequest usuarioRequest, HttpServletRequest request) {
		var response = usuarioService.update(id, usuarioRequest);
		return MensagemSistema.showMensagem(
			"Usuário alterado com sucesso",
			HttpStatus.OK,
			response,
			request
		);
	}
	
	@Override
	@GetMapping(value = "/buscar/{id}")
	public ResponseEntity<?> findById(@PathVariable Long id, HttpServletRequest request) {
		var response = usuarioService.findById(id);
		return MensagemSistema.showMensagem(
			"Usuário localizado com sucesso",
			HttpStatus.OK,
			response,
			request
		);
	}
	
	@Override
	@DeleteMapping(value = "/excluir/{id}")
	public ResponseEntity<?> deleteById(@PathVariable Long id, HttpServletRequest request) {
		usuarioService.deleteById(id);
		return MensagemSistema.showMensagem(
			"Usuário excluído com sucesso",
			HttpStatus.NO_CONTENT,
			request
		);
	}
}
