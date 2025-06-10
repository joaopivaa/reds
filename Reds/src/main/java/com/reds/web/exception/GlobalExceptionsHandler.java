package com.reds.web.exception;

import java.util.List;
import java.util.stream.Collectors;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.MessageSource;
import org.springframework.context.i18n.LocaleContextHolder;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

import com.reds.models.service.dto.response.FieldsResponse;
import com.reds.models.service.exception.FieldEntityNotEmpty;
import com.reds.web.response.MensagemSistema;

import jakarta.servlet.http.HttpServletRequest;

@RestControllerAdvice(basePackages = "com.reds") // Captura exceções do projeto inteiro
public class GlobalExceptionsHandler {
	
	@Autowired
	private MessageSource messageSource;
	
	// Erros de digitação do usuário no input (vazio ou espaço em branco)

	@ExceptionHandler(MethodArgumentNotValidException.class)
	public ResponseEntity<?> handlerValidationException(MethodArgumentNotValidException ex, HttpServletRequest request) {
	
		List<FieldsResponse> listaErrors = ex.getBindingResult()
											 .getFieldErrors()
											 .stream()
											 .map(fieldError -> {
												 FieldsResponse fields = new FieldsResponse();
												 fields.setField(fieldError.getField());
												 fields.setMessage(messageSource.getMessage(fieldError, LocaleContextHolder.getLocale()));
												 return fields;
											 }).collect(Collectors.toList());
											
		return MensagemSistema.showMensagem("Erro na digitação dos dados", HttpStatus.UNPROCESSABLE_ENTITY, listaErrors, request);
	}	
	
	@ExceptionHandler(FieldEntityNotEmpty.class)
	public ResponseEntity<?> handlerValidationException(FieldEntityNotEmpty ex, HttpServletRequest request) {
		return MensagemSistema.showMensagem(ex.getMessage(), HttpStatus.UNPROCESSABLE_ENTITY, request);
	}
}
