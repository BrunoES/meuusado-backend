package com.meuusado.jwt;

import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Component;

import com.meuusado.application.domain.Usuario;

@Component
public class UserDetailsServiceImpl implements UserDetailsService {

	@Override
	public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
		BCryptPasswordEncoder cypto = new BCryptPasswordEncoder();
		Usuario usuario = new Usuario(1L, "Bruno", "brunoh915@gmail.com", cypto.encode("1234"));
		UserDetails userDetails = new UserDetailsData(usuario);
		return userDetails;
	}

}