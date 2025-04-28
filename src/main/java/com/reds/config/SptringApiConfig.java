package com.reds.config;

import java.util.Arrays;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import io.swagger.v3.oas.models.tags.Tag;
import io.swagger.v3.oas.models.ExternalDocumentation;
import io.swagger.v3.oas.models.OpenAPI;
import io.swagger.v3.oas.models.info.Info;
import io.swagger.v3.oas.models.info.License;

@Configuration
public class SptringApiConfig {

	@Bean // Executa sozinha para gente
	OpenAPI customOpenApi() {
		return new OpenAPI().info(info())
							.externalDocs(
								new ExternalDocumentation()
									.description("IFSP")
									.url("http://bri.ifsp.edu.br")
							)
							.tags(Arrays.asList(
									new Tag().name("Usuário").description("Gerencia o cadastro de usuário no sistema."),
									new Tag().name("Aluno").description("Gerencia o cadastro de aluno no sistema."),
									new Tag().name("Professor").description("Gerencia o cadastro de professor no sistema."),
									new Tag().name("Avaliação").description("Gerencia o cadastro de avaliação no sistema."),
									new Tag().name("Disciplina").description("Gerencia o cadastro de disciplina no sistema."),
									new Tag().name("Cidade").description("Gerencia o cadastro de cidade no sistema.")
								)
							);
	}

	// Retorna uma instância de uma nova informação
	private Info info() {
		return new Info().title("RESTfull API with java 19 and Spring Boot v. 3.1.2")
						 .version("v1")
						 .description("Descrição dos rescursos oferecidos pela API")
						 .termsOfService("http://bri.ifsp.edu.br")
						 .license(
							new License().name("Apache 2.0")
										 .url("http://www.apache.org/licenses/LICENSE-2.0")
						 );
	}
}
