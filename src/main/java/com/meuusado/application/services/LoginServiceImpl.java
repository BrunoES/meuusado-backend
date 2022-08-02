package com.meuusado.application.services;

import com.meuusado.adapters.dtos.LoginDTO;
import com.meuusado.application.domain.Usuario;
import com.meuusado.application.ports.LoginServicePort;
import com.meuusado.application.ports.UsuarioRepositoryPort;

public class LoginServiceImpl implements LoginServicePort {

	private final UsuarioRepositoryPort usuarioRepositoryPort;
	
	public LoginServiceImpl(final UsuarioRepositoryPort usuarioRepositoryPort) {
		this.usuarioRepositoryPort = usuarioRepositoryPort;
	}
	
	@Override
	public boolean signIn(LoginDTO loginDto) {
		Usuario usuario = usuarioRepositoryPort.findByEmail(loginDto.getEmail());
		if(usuario != null) {
			if(loginDto.getPassword().equals(usuario.password())) {
				return true;
			}
		}
		return false;
	}
	
	@Override
	public void logOut(LoginDTO loginDto) {
		// TO DO
	}
	
}
