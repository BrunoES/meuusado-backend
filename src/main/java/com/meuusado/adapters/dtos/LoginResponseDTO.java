package com.meuusado.adapters.dtos;

import java.io.Serializable;

public class LoginResponseDTO implements Serializable {

	public LoginResponseDTO(boolean response) {
		this.response = response;
	}

	private static final long serialVersionUID = 1L;
	
	private boolean response;

	public boolean isResponse() {
		return response;
	}

	public void setResponse(boolean response) {
		this.response = response;
	}
	
}
