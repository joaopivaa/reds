package com.reds.models.service.impl;

import java.security.Key;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.stereotype.Component;

import com.reds.config.SpringProjectConfig;
import com.reds.models.model.Usuario;
import com.reds.models.model.UsuarioRolePermission;
import com.reds.models.repository.UsuarioRepository;
import com.reds.models.repository.UsuarioRolePermissionRepository;
import com.reds.models.service.JwtService;

import io.jsonwebtoken.Claims;
import io.jsonwebtoken.Jwts;
import io.jsonwebtoken.SignatureAlgorithm;
import io.jsonwebtoken.io.Decoders;
import io.jsonwebtoken.security.Keys;
import jakarta.persistence.EntityNotFoundException;

@Component
public class JwtServiceImpl implements JwtService {
	
	@Autowired
	private UsuarioRepository usuarioRepository;
	
	@Autowired
	private UsuarioRolePermissionRepository usuarioRolePermissionRepository;
	
	@Override
	public String getEmail(String token) {
		return Jwts
			.parserBuilder()
		    .setSigningKey(getSignInKey())
		    .build()
		    .parseClaimsJws(token)
		    .getBody()
		    .getSubject();
	}

	@Override
	public Date verifyDateExpiration(String token) {
		Claims claims = Jwts.parserBuilder().setSigningKey(getSignInKey()).build().parseClaimsJws(token).getBody();
		return claims.getExpiration();
		}

	@Override
	public String generateAccessToken(Usuario usuario) {
		return createToken(usuario,SpringProjectConfig.ACCESS_TOKEN_EXPIRATION);
	}

	private String createToken(Usuario usuario, long time) {
		Map<String, Object> claims = generateClaims(usuario);
		
		
		
		return Jwts.builder()
				.setClaims(claims)
				.setSubject(usuario.getEmail())
				.setIssuedAt(new Date(System.currentTimeMillis()))
				.setExpiration(new Date(System.currentTimeMillis()+time))
				.signWith(getSignInKey(),SignatureAlgorithm.HS256)
				.compact();
	}

	private Map<String, Object> generateClaims(Usuario usuario) {
		List<UsuarioRolePermission> listaRolePermission = usuarioRolePermissionRepository.findUsuarioRolePermissionById(usuario.getIdUsuario());
		List<String> roles = listaRolePermission.stream().map(urp -> urp.getRole().getNomeRoles().getNomeRole()).collect(Collectors.toSet()).stream().collect(Collectors.toList());
		List<String> permission = listaRolePermission.stream().map(urp -> urp.getPermissions().getNomePermissions().getNomePermissions()).collect(Collectors.toSet()).stream().collect(Collectors.toList());
		Map<String,Object> claims = new HashMap<String, Object>();
		claims.put("id", usuario.getIdUsuario());
		claims.put("nome", usuario.getNomeUsuario());
		claims.put("roles", roles);
		claims.put("permission", permission);
		return null;
	}

	@Override
	public String generateRefreshToken(Usuario usuario) {
		return createToken(usuario,SpringProjectConfig.REFRESH_TOKEN_EXPIRATION);
	}

	@Override
	public boolean verifyToken(String token) {
		Usuario usuario = usuarioRepository.findUsuarioByEmail(token)
				.orElseThrow(()->new EntityNotFoundException("Usuario Não Cadastrado"));
		String nome = getClaims(token, "Nome");
		return (!((nome.equals(usuario.getNomeUsuario()))&& !verifyTokenExpiration(token)));
	}

	@Override
	public boolean isTokenValid(String token, UserDetails userDetails) {
		String nome = getClaims(token,"nome");
		
		return (!((nome.equals(userDetails.getUsername()))&& !verifyTokenExpiration(token)));
	}
	
	private boolean verifyTokenExpiration(String token) {
		Date expirateionDate = verifyDateExpiration(token);
		return expirateionDate.before(new Date());
	}

	private String getClaims(String token, String key) {
		Claims claims = Jwts.parserBuilder()
				.setSigningKey(getSignInKey())
				.build()
				.parseClaimsJws(token)
				.getBody();
		return claims.get(key).toString();
	}

	private Key getSignInKey() {
		byte[] keyBytes = Decoders.BASE64.decode(SpringProjectConfig.SECRETKEY);
		return Keys.hmacShaKeyFor(keyBytes);
	}
}
