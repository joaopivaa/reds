package com.reds.web.swagger;

import org.springframework.http.ResponseEntity;

import com.reds.models.service.dto.request.PerguntaRequest;
import com.reds.models.service.dto.response.PerguntaResponse;

import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.Parameter;
import io.swagger.v3.oas.annotations.media.ArraySchema;
import io.swagger.v3.oas.annotations.media.Content;
import io.swagger.v3.oas.annotations.media.Schema;
import io.swagger.v3.oas.annotations.parameters.RequestBody;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.tags.Tag;
import jakarta.servlet.http.HttpServletRequest;

@Tag(name = "Pergunta", description = "Endpoints para Gerenciar os Dados da Pergunta")
public interface PerguntaControllerApi {
	@Operation(
			summary = "Relatorio de Todas As Pergunta no Sistema com Paginação no cliente",
			description = "Relatorio de Todas As Pergunta",
			responses = {
					@ApiResponse(
							responseCode = "200",
							content = {
									@Content(
										mediaType = "application/json",
										array = @ArraySchema(schema = @Schema(implementation = PerguntaResponse.class))
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
			summary = "Cadastro da Pergunta no sistema",
			description = "Necessita de todos os dados válidos",
			responses = {
			@ApiResponse (
					responseCode = "200",
					content = {
						@Content (
							mediaType = "application/json",
							array = @ArraySchema(schema = @Schema(implementation = PerguntaResponse.class))
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
			@RequestBody(description = "Representação de uma nova Pergunta para cadastrar no sistema", required = true)
			PerguntaRequest perguntaRequest, 
			HttpServletRequest request
		);
	
	@Operation(
			summary = "Alteração de dados da Pergunta no sistema",
			description = "Necessita de todos os dados válidos",
			responses = {
			@ApiResponse (
					responseCode = "200",
					content = {
						@Content (
							mediaType = "application/json",
							array = @ArraySchema(schema = @Schema(implementation = PerguntaResponse.class))
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
			@Parameter(description = "Identificador único da Pergunta no Sistema", example = "1", required = true)
			Long id, 
			@RequestBody(description = "Representação de uma Pergunta para cadastrado no sistema para alteração das informações", required = true)
			PerguntaRequest perguntaRequest, 
			HttpServletRequest request
		);
	
	@Operation(
			summary = "Pesquisa os dados da Pergunta no sistema",
			description = "Necessita de um identificador único da Pergunta válido",
			responses = {
			@ApiResponse (
					responseCode = "200",
					content = {
						@Content (
							mediaType = "application/json",
							array = @ArraySchema(schema = @Schema(implementation = PerguntaResponse.class))
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
			@Parameter(description = "Identificador único da Pergunta no sistema", example = "1", required = true)
			Long id, 
			HttpServletRequest request
		);
	
	@Operation(
			summary = "Exclusão de dados da Pergunta no sistema",
			description = "Necessita de um identificador único da Pergunta válido",
			responses = {
				@ApiResponse (
					responseCode = "200",
					content = {
						@Content (
							mediaType = "application/json",
							array = @ArraySchema(schema = @Schema(implementation = PerguntaResponse.class))
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
			@Parameter(description = "Identificador único da Pergunta no sistema", example = "1", required = true)
			Long id, 
			HttpServletRequest request
		);
}
