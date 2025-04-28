package com.reds.web.swagger;

import org.springframework.http.ResponseEntity;

import com.reds.models.service.dto.request.UsuarioRequest;
import com.reds.models.service.dto.response.UsuarioResponse;

import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.Parameter;
import io.swagger.v3.oas.annotations.media.ArraySchema;
import io.swagger.v3.oas.annotations.media.Content;
import io.swagger.v3.oas.annotations.media.Schema;
import io.swagger.v3.oas.annotations.parameters.RequestBody;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.tags.Tag;
import jakarta.servlet.http.HttpServletRequest;

@Tag(name = "Usuário", description = "Endpoints para gerenciar os dados do usuário") // Dizer que pertence à determinado controlador
public interface UsuarioControllerApi {

	// Refere-se a operação documentada
	@Operation(
		summary = "Relatório de todos os usuários no sistema com paginação no cliente",
		description = "Relatório de todos os usuários",
		responses = {
			@ApiResponse (
				responseCode = "200",
				content = {
					@Content (
						mediaType = "application/json",
						array = @ArraySchema(schema = @Schema(implementation = UsuarioResponse.class))
					)
				}
			),
			@ApiResponse (
				description = "Bad Request",
				responseCode = "400",
				content = @Content
			),
			@ApiResponse (
				description = "Unauthorized",
				responseCode = "401",
				content = @Content
			),
			@ApiResponse (
				description = "Not Found",
				responseCode = "404",
				content = @Content
			),
			@ApiResponse (
				description = "Internal Error",
				responseCode = "500",
				content = @Content
			)
		}
	)
	ResponseEntity<?> listar(HttpServletRequest request);

	@Operation(
		summary = "Cadastro de dados do usuário no sistema",
		description = "Necessita de todos os dados válidos",
		responses = {
			@ApiResponse (
				responseCode = "200",
				content = {
					@Content (
						mediaType = "application/json",
						array = @ArraySchema(schema = @Schema(implementation = UsuarioResponse.class))
					)
				}
			),
			@ApiResponse (
				description = "Bad Request",
				responseCode = "400",
				content = @Content
			),
			@ApiResponse (
				description = "Unauthorized",
				responseCode = "401",
				content = @Content
			),
			@ApiResponse (
				description = "Not Found",
				responseCode = "404",
				content = @Content
			),
			@ApiResponse (
				description = "Internal Error",
				responseCode = "500",
				content = @Content
			)
		}
	)
	ResponseEntity<?> save(
		@RequestBody(description = "Representação de um novo usuário para cadastrar no sistema", required = true)
		UsuarioRequest usuarioRequest, 
		HttpServletRequest request
	);

	@Operation(
		summary = "Alteração de dados do usuário no sistema",
		description = "Necessita de todos os dados válidos",
		responses = {
			@ApiResponse (
				responseCode = "200",
				content = {
					@Content (
						mediaType = "application/json",
						array = @ArraySchema(schema = @Schema(implementation = UsuarioResponse.class))
					)
				}
			),
			@ApiResponse (
				description = "Bad Request",
				responseCode = "400",
				content = @Content
			),
			@ApiResponse (
				description = "Unauthorized",
				responseCode = "401",
				content = @Content
			),
			@ApiResponse (
				description = "Not Found",
				responseCode = "404",
				content = @Content
			),
			@ApiResponse (
				description = "Internal Error",
				responseCode = "500",
				content = @Content
			)
		}
	)
	ResponseEntity<?> update(
		@Parameter(description = "Identificador único do usuário no sistema", example = "1", required = true)
		Long id, 
		@RequestBody(description = "Representação de um usuário para cadastrado no sistema para alteração das informações", required = true)
		UsuarioRequest usuarioRequest, 
		HttpServletRequest request
	);

	@Operation(
		summary = "Pesquisar dados do usuário no sistema",
		description = "Necessita de um identificador único do usuário válido",
		responses = {
			@ApiResponse (
				responseCode = "200",
				content = {
					@Content (
						mediaType = "application/json",
						array = @ArraySchema(schema = @Schema(implementation = UsuarioResponse.class))
					)
				}
			),
			@ApiResponse (
				description = "Bad Request",
				responseCode = "400",
				content = @Content
			),
			@ApiResponse (
				description = "Unauthorized",
				responseCode = "401",
				content = @Content
			),
			@ApiResponse (
				description = "Not Found",
				responseCode = "404",
				content = @Content
			),
			@ApiResponse (
				description = "Internal Error",
				responseCode = "500",
				content = @Content
			)
		}
	)
	ResponseEntity<?> findById(
		@Parameter(description = "Identificador único do usuário no sistema", example = "1", required = true)
		Long id, 
		HttpServletRequest request
	);

	@Operation(
		summary = "Exclusão de dados do usuário no sistema",
		description = "Necessita de um identificador único do usuário válido",
		responses = {
			@ApiResponse (
				responseCode = "200",
				content = {
					@Content (
						mediaType = "application/json",
						array = @ArraySchema(schema = @Schema(implementation = UsuarioResponse.class))
					)
				}
			),
			@ApiResponse (
				description = "Bad Request",
				responseCode = "400",
				content = @Content
			),
			@ApiResponse (
				description = "Unauthorized",
				responseCode = "401",
				content = @Content
			),
			@ApiResponse (
				description = "Not Found",
				responseCode = "404",
				content = @Content
			),
			@ApiResponse (
				description = "Internal Error",
				responseCode = "500",
				content = @Content
			)
		}
	)
	ResponseEntity<?> deleteById(
		@Parameter(description = "Identificador único do usuário no sistema", example = "1", required = true)
		Long id, 
		HttpServletRequest request
	);
}