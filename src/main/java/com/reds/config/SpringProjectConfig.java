package com.reds.config;

public class SpringProjectConfig {
	
	public static final String SECRETKEY = "MinhaChaveSecretaDeAcessoAoSistemaUtilizandoJwtComSpringSecurity";
	public static final long ACCESS_TOKEN_EXPIRATION = 5 * 60 * 1000;
	public static final long REFRESH_TOKEN_EXPIRATION = 2 * 60 * 60 * 1000;
	
    public static final String[] WHITE_LIST_URL = {
        "/docs/index.html",
        "/docs-park.html",
        "/dovs-park/**",
        "/v3/api-docs/**",
        "/swagger-ui-custom.html",
        "/swagger-ui.html",
        "/swagger-ui/**",
        "/**.html",
        "/webjar/**",
        "/configuration/**",
        "/swagger-resources/**"
    };
    
    public static final String[][] END_POINTS_WITH_AUTHENTICATION_NOT_REQUIRED = {
			{"POST","/rest/login"},
			{"POST","/rest/checkopt"}
	};
}