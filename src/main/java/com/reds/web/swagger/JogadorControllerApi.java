package com.reds.web.swagger;

import org.springframework.http.ResponseEntity;

import com.reds.models.service.dto.request.JogadorRequest;
import com.reds.models.service.dto.response.JogadorResponse;

import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.Parameter;
import io.swagger.v3.oas.annotations.media.ArraySchema;
import io.swagger.v3.oas.annotations.media.Content;
import io.swagger.v3.oas.annotations.media.Schema;
import io.swagger.v3.oas.annotations.parameters.RequestBody;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.tags.Tag;
import jakarta.servlet.http.HttpServletRequest;

@Tag(name = "Jogador", description = "Endpoints para Gerenciar os Dados do Jogador")
public interface JogadorControllerApi {
	
	@Operation(
			summary = "Relatorio de Todos os Jogadores no Sistema com Paginação no cliente",
			description = "Relatorio de Todo os Jogadores",
			responses = {
					@ApiResponse(
							responseCode = "200",
							content = {
									@Content(
										mediaType = "application/json",
										array = @ArraySchema(schema = @Schema(implementation = JogadorResponse.class))
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
			summary = "Cadastro do Jogador no sistema",
			description = "Necessita de todos os dados válidos",
			responses = {
			@ApiResponse (
					responseCode = "200",
					content = {
						@Content (
							mediaType = "application/json",
							array = @ArraySchema(schema = @Schema(implementation = JogadorResponse.class))
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
			@RequestBody(description = "Representação de um novo Jogador para cadastrar no sistema", required = true)
			JogadorRequest jogadorRequest, 
			HttpServletRequest request
		);
	
	@Operation(
			summary = "Alteração de dados do Jogador no sistema",
			description = "Necessita de todos os dados válidos",
			responses = {
			@ApiResponse (
					responseCode = "200",
					content = {
						@Content (
							mediaType = "application/json",
							array = @ArraySchema(schema = @Schema(implementation = JogadorResponse.class))
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
			@Parameter(description = "Identificador único do Jogador no Sistema", example = "1", required = true)
			Long id, 
			@RequestBody(description = "Representação de um Jogador para cadastrado no sistema para alteração das informações", required = true)
			JogadorRequest jogadorRequest, 
			HttpServletRequest request
		);
	
	@Operation(
			summary = "Pesquisa os dados do Jogador no sistema",
			description = "Necessita de um identificador único do Jogador válido",
			responses = {
			@ApiResponse (
					responseCode = "200",
					content = {
						@Content (
							mediaType = "application/json",
							array = @ArraySchema(schema = @Schema(implementation = JogadorResponse.class))
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
			@Parameter(description = "Identificador único do Jogador no sistema", example = "1", required = true)
			Long id, 
			HttpServletRequest request
		);
	
	@Operation(
			summary = "Exclusão de dados do Jogador no sistema",
			description = "Necessita de um identificador único do Jogador válido",
			responses = {
				@ApiResponse (
					responseCode = "200",
					content = {
						@Content (
							mediaType = "application/json",
							array = @ArraySchema(schema = @Schema(implementation = JogadorResponse.class))
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
			@Parameter(description = "Identificador único do Jogador no sistema", example = "1", required = true)
			Long id, 
			HttpServletRequest request
		);
}
