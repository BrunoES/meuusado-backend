package com.meuusado.adapters.outbound.authentication.jwt;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Component;

import com.meuusado.application.domain.Usuario;
import com.meuusado.application.services.UsuarioServiceImpl;

@Component
public class UserDetailsServiceImpl implements UserDetailsService {

	@Autowired
	private UsuarioServiceImpl usuarioServiceImpl;
	
	@Override
	public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
		Usuario usuario = usuarioServiceImpl.findByEmail(username);
		BCryptPasswordEncoder cypto = new BCryptPasswordEncoder();
		String encryptedPassword = cypto.encode(usuario.password());
		
		UserDetails userDetails = new UserDetailsData(new Usuario(usuario.idUsuario(), usuario.nome(), usuario.email(), encryptedPassword));
		return userDetails;
	}

}