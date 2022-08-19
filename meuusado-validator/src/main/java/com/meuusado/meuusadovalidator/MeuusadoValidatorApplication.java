package com.meuusado.meuusadovalidator;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Configuration;

import com.meuusado.meuusadovalidator.service.AprovaAnuncioService;

@SpringBootApplication
public class MeuusadoValidatorApplication {

	@Autowired
	private static AprovaAnuncioService aprovaAnuncioService;
	
	public static void main(String[] args) {
		SpringApplication.run(MeuusadoValidatorApplication.class, args);
		try {
			aprovaAnuncioService.consume();
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	
}