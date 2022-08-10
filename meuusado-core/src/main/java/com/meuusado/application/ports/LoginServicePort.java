package com.meuusado.application.ports;

import com.meuusado.adapters.dtos.LoginDTO;

public interface LoginServicePort {
	
	boolean signIn(LoginDTO loginDto);
	
	void logOut(LoginDTO loginDto);
	
}
