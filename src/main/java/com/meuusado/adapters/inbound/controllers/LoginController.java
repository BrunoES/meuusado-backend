package com.meuusado.adapters.inbound.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.meuusado.dtos.LoginDTO;
import com.meuusado.dtos.LoginResponseDTO;
import com.meuusado.services.LoginService;

@RestController
@RequestMapping(value="/api/v1/login")
public class LoginController {
	
	@Autowired
	private LoginService LoginService;
	
	@RequestMapping(method=RequestMethod.POST)
	public ResponseEntity<LoginResponseDTO> save(@RequestBody LoginDTO loginDto) {
		boolean logado = LoginService.signIn(loginDto);
		LoginResponseDTO loginResponseDTO = new LoginResponseDTO(logado);
		return new ResponseEntity<LoginResponseDTO>(loginResponseDTO, (logado ? HttpStatus.OK : HttpStatus.UNAUTHORIZED));
	}
	
}
