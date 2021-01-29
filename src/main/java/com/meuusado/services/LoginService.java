package com.meuusado.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.meuusado.dtos.LoginDTO;
import com.meuusado.entities.Usuario;
import com.meuusado.repository.UsuarioRepository;

@Service
public class LoginService {

	@Autowired
	private UsuarioRepository usuarioRepository;
	
	public boolean signIn(LoginDTO loginDto) {
		Usuario usuario = usuarioRepository.findByEmail(loginDto.getEmail());
		if(usuario != null) {
			if(loginDto.getPassword().equals(usuario.getPassword())) {
				return true;
			}
		}
		return false;
	}
	
	public void logOut(LoginDTO loginDto) {
		// TO DO
	}
	
}
