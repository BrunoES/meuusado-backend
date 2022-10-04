package com.meuusado.adapters.outbound.authentication.security;

import java.io.IOException;
import java.util.ArrayList;
import java.util.Date;

import javax.servlet.FilterChain;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.core.log.LogMessage;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.authentication.event.InteractiveAuthenticationSuccessEvent;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.AuthenticationException;
import org.springframework.security.core.context.SecurityContext;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.web.authentication.UsernamePasswordAuthenticationFilter;

import com.auth0.jwt.JWT;
import com.auth0.jwt.algorithms.Algorithm;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.meuusado.adapters.dtos.UsuarioDTO;
import com.meuusado.adapters.outbound.authentication.jwt.UserDetailsData;

public class JwtAuthenticationFilter extends UsernamePasswordAuthenticationFilter {

	private static final int TOKEN_EXPIRATION = 600_000;
	
	// @Value("${jwt.token.password}") Mover para properties
	public static final String TOKEN_PASSWORD = "51sa16a1da6da21sa74132sas";
	
	private final AuthenticationManager authenticationManager;

	public JwtAuthenticationFilter(AuthenticationManager authenticationManager) {
		super();
		this.authenticationManager = authenticationManager;
	}
	
	@Override
	public Authentication attemptAuthentication(HttpServletRequest request, HttpServletResponse response)
			throws AuthenticationException {
		
		UsuarioDTO usuarioDTO = null;
		
		try {
			usuarioDTO = new ObjectMapper().readValue(request.getInputStream(), UsuarioDTO.class);
		} catch (IOException e) {
			e.printStackTrace();
		}
		
		return authenticationManager.authenticate(new UsernamePasswordAuthenticationToken(usuarioDTO.getEmail(), usuarioDTO.getPassword(), new ArrayList<>()));
	}
	
	@Override
	protected void successfulAuthentication(HttpServletRequest request, HttpServletResponse response, FilterChain chain,
			Authentication authResult) throws IOException, ServletException {
		UserDetailsData userDetailsData = (UserDetailsData) authResult.getPrincipal();
		
		String token = JWT.create()
				.withSubject(userDetailsData.getUsername())
						.withExpiresAt(new Date(System.currentTimeMillis() + TOKEN_EXPIRATION))
						.sign(Algorithm.HMAC512(TOKEN_PASSWORD));
		response.getWriter().write(token);
		response.getWriter().flush();
	}

	
	
}
