package com.meuusado.adapters.outbound.authentication.jwt;

import java.util.ArrayList;
import java.util.Collection;

import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;

import com.meuusado.application.domain.Usuario;

public class UserDetailsData implements UserDetails {

	private final Usuario usuario;
	
	public UserDetailsData(Usuario usuario) {
		super();
		this.usuario = usuario;
	}

	@Override
	public Collection<? extends GrantedAuthority> getAuthorities() {
		new ArrayList<>();
		return null;
	}

	@Override
	public String getPassword() {
		return usuario.password();
	}

	@Override
	public String getUsername() {
		return usuario.email();
	}

	@Override
	public boolean isAccountNonExpired() {
		// TODO Auto-generated method stub
		return true;
	}

	@Override
	public boolean isAccountNonLocked() {
		// TODO Auto-generated method stub
		return true;
	}

	@Override
	public boolean isCredentialsNonExpired() {
		// TODO Auto-generated method stub
		return true;
	}

	@Override
	public boolean isEnabled() {
		// TODO Auto-generated method stub
		return true;
	}

}
