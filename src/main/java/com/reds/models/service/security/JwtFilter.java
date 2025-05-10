package com.reds.models.service.security;

import java.io.IOException;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.web.filter.OncePerRequestFilter;

import com.reds.models.service.JwtService;

import jakarta.servlet.FilterChain;
import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

public class JwtFilter extends OncePerRequestFilter{
	@Autowired
	private JwtService jwtService;
	
	@Autowired
	private UserDetailsService userDetailsService;
	
	@Override
	protected void doFilterInternal(HttpServletRequest request, HttpServletResponse response, FilterChain filterChain)
			throws ServletException, IOException {
		final String authHeader = request.getHeader("Authorization");
		String jwt = null;
		String email = null;
		String jwtToken = null;
		
		if(request.getServletPath().contains("/rest/login")) {
			filterChain.doFilter(request, response);
			return;
		};
		if(authHeader == null || authHeader.startsWith("Bearer ")) {
			filterChain.doFilter(request,response);
			return;
		};
		
		jwt = authHeader.substring(7);
		
		if(jwt==null) {
			filterChain.doFilter(request, response);
		}
		
		email = jwtService.getEmail(jwt);
		
		try {
			if(!jwtService.verifyToken(jwtToken)) {
				throw new AccessForbiddenException("Token Invalido");
			}
			if(email != null && SecurityContextHolder.getContext().getAuthentication() == null) {
				UserDetails userDetails = userDetailsService.loadUserByUsername(email);
				if(jwtService.isTokenValid(jwt, userDetails)) {
					UsernamePasswordAuthenticationToken authToken = new UsernamePasswordAuthenticationToken(userDetails,null, userDetails.getAuthorities());
					SecurityContextHolder.getContext().setAuthentication(authToken);
				}
			}
			filterChain.doFilter(request, response);
		}catch (Exception e) {
			throw new AccessForbiddenException("Acesso Negado");
		}
	}
}
