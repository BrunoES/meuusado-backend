package com.meuusado.jwt;

import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;

import com.meuusado.application.domain.Usuario;

public class UserDetailsServiceImpl implements UserDetailsService {

	@Override
	public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
		Usuario usuario = new Usuario(1L, "Bruno", "brunoh915@gmail.com", "0211");
		UserDetails userDetails = new UserDetailsData(usuario);
		return userDetails;
	}

}
