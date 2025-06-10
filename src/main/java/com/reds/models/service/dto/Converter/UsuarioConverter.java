package com.reds.models.service.dto.Converter;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

import com.reds.models.model.Usuario;
import com.reds.models.repository.projection.UsuarioCidadeProjection;
import com.reds.models.service.dto.request.UsuarioRequest;
import com.reds.models.service.dto.response.LoginResponse;
import com.reds.models.service.dto.response.UsuarioResponse;

public class UsuarioConverter {
	
	public static Usuario toUsuario(UsuarioRequest usuarioRequest) {
		return new Usuario(
			usuarioRequest.getNomeUsuario(),
			usuarioRequest.getEmail()
		);
	}
	
	public static List<UsuarioResponse> toListUsuarioResponse(List<Usuario> listaUsuario) {
		List<UsuarioResponse> listaUsuarioResponse = new ArrayList<UsuarioResponse>();

		for (Usuario usuario: listaUsuario) {
			UsuarioResponse usuarioResponse = toUsuarioResponse(usuario);
			listaUsuarioResponse.add(usuarioResponse);
		}
		
		return listaUsuarioResponse;
	}
	
    public static UsuarioResponse toUsuarioResponse(Usuario usuario) {
        return new UsuarioResponse(
            usuario.getIdUsuario(),
            usuario.getNomeUsuario(),
            usuario.getEmail()
        );
    }
	public static List<UsuarioResponse> projectionListUsuarioResponse(List<UsuarioCidadeProjection> listaUsuario) {
		return listaUsuario.stream()
				.map(projection -> new UsuarioResponse(
						projection.getIdUsuario(),
						projection.getNomeUsuario(),
						projection.getEmail()

				))
				.collect(Collectors.toList());
	}

	public static LoginResponse usuarioToLoginResponse(Usuario usuario, String access_token, String refresh_token,
			List<String> roles, List<String> permissions) {
		return new LoginResponse(
				usuario.getIdUsuario(),
				usuario.getNomeUsuario(),
				usuario.getEmail(),
				access_token,
				refresh_token,
				roles,
				permissions
		);
	}
}
