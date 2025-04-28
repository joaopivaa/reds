package com.reds.web.response;

import java.time.LocalDateTime;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import jakarta.servlet.http.HttpServletRequest;

public class MensagemSistema {

	public static <T> ResponseEntity<?> showMensagem(String mensagem, HttpStatus status, T dados, HttpServletRequest request) {
		return mensagem(new Mensagem.Builder<T>().status(status.value()).mensagem(mensagem).dados(dados).path(request.getRequestURI()).metodo(request.getMethod()).data(LocalDateTime.now()));
	}
	
	public static <T> ResponseEntity<?> showMensagem(HttpStatus status, T dados, HttpServletRequest request) {
		return mensagem(new Mensagem.Builder<T>().status(status.value()).dados(dados).path(request.getRequestURI()).metodo(request.getMethod()).data(LocalDateTime.now()));
	}
	
	public static <T> ResponseEntity<?> showMensagem(String mensagem, HttpStatus status, HttpServletRequest request) {
		return mensagem(new Mensagem.Builder<T>().status(status.value()).mensagem(mensagem).path(request.getRequestURI()).metodo(request.getMethod()).data(LocalDateTime.now()));
	}
	
	private static <T> ResponseEntity<?> mensagem(Mensagem.Builder<T> builder) {
		return ResponseEntity.status(builder.build().getStatus()).body(builder.build());
	}
}
