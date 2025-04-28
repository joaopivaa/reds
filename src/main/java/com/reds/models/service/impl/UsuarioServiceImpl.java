package com.reds.models.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.reds.models.repository.UsuarioRepository;
import com.reds.models.repository.projection.UsuarioCidadeProjection;
import com.reds.models.service.UsuarioService;
import com.reds.models.service.dto.Converter.UsuarioConverter;
import com.reds.models.service.dto.request.UsuarioRequest;
import com.reds.models.service.dto.response.UsuarioResponse;
import com.reds.models.service.exception.EntityNotFoundException;

@Service
@Transactional
public class UsuarioServiceImpl implements UsuarioService { // Beans
	
	@Autowired // Cria a instância
	private UsuarioRepository usuarioRepository; // Para gravação usa-se o repository
	

	@Override
	public UsuarioResponse save(UsuarioRequest entity) {
		
		var usuario = UsuarioConverter.toUsuario(entity);
		
		usuario = usuarioRepository.saveAndFlush(usuario);
		
		var usuarioResponse = UsuarioConverter.toUsuarioResponse(usuario);
		
		return usuarioResponse; // Save and Flush retorna um objeto, entity é a própria usuario
	}

	@Override
	public UsuarioResponse update(Long id, UsuarioRequest entity) {
		var usuario = usuarioRepository.findById(id)
				.orElseThrow(
						()-> new EntityNotFoundException(
								String.format("Usuario não localizado %s", 
								String.valueOf(id))));
		
		
		usuario.setEmail(entity.getEmail());
		usuario.setNomeUsuario(entity.getNomeUsuario());
		
		usuario = usuarioRepository.saveAndFlush(usuario);
		
		return UsuarioConverter.toUsuarioResponse(usuario);
		//return save(usuarioCadastrado);
	}

	@Override
	public void deleteById(Long id) {
		usuarioRepository.deleteById(id);
	}

	@Override
	@Transactional(readOnly = true)
	public UsuarioResponse findById(Long id) {
		var usuario = usuarioRepository.findById(id).orElseThrow(()-> new EntityNotFoundException(
				String.format("Usuario não localizado %s", String.valueOf(id))));
		
		var usuarioResponse = UsuarioConverter.toUsuarioResponse(usuario);
		
		return usuarioResponse;
	}

	@Override
	public List<UsuarioResponse> listar() {
		List<UsuarioCidadeProjection> listaUsuario = usuarioRepository.listagemUsuario();
		List<UsuarioResponse> listaUsuarioResponse = UsuarioConverter.projectionListUsuarioResponse(listaUsuario);
		
		return listaUsuarioResponse;
	}

}
