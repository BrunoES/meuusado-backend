package com.meuusado.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.meuusado.dtos.LoginDTO;
import com.meuusado.services.LoginService;

@RestController
@RequestMapping(value="/api/v1/login")
public class LoginController {
	
	@Autowired
	private LoginService LoginService;
	
	@RequestMapping(method=RequestMethod.POST)
	public ResponseEntity<Boolean> save(@RequestBody LoginDTO loginDto) {
		boolean logado = LoginService.signIn(loginDto);
		return new ResponseEntity<>(logado, (logado ? HttpStatus.OK : HttpStatus.UNAUTHORIZED));
	}
	
}
