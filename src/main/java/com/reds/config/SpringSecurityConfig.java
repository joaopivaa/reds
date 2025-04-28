package com.reds.config;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.method.configuration.EnableMethodSecurity;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.http.SessionCreationPolicy;
import org.springframework.security.web.SecurityFilterChain;

import com.reds.models.service.components.CriptografarSenha;
import com.reds.models.service.security.UsuarioDetailsService;

@Configuration
@EnableWebSecurity
@EnableMethodSecurity(securedEnabled = true)
public class SpringSecurityConfig {
	
	@Autowired
	private CriptografarSenha crypt;
	
	@Autowired
	private UsuarioDetailsService userDetailsService;
	@Bean
	SecurityFilterChain filtherChainSecurity(HttpSecurity http) throws Exception{
		http.csrf(csrf->csrf.disable());
		http.formLogin(form->form.disable());
		http.httpBasic(basic->basic.disable());
		http.sessionManagement(session->session.sessionCreationPolicy(SessionCreationPolicy.STATELESS));
		http.securityMatcher("/**");
		
		http.authorizeHttpRequests(
				auth->{
					auth.requestMatchers(SpringProjectConfig.WHITE_LIST_URL).permitAll();
					auth.anyRequest().permitAll();
				}
		);
		 return http.build();
	}
	@Bean
	AuthenticationManager authenticationManager(HttpSecurity http) throws Exception {
		var builder = http.getSharedObject(AuthenticationManagerBuilder.class);
		builder.userDetailsService(userDetailsService).passwordEncoder(crypt.passwordEncoder());
		return builder.build();
	}
}
