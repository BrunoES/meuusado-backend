package com.meuusado;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;

@SpringBootApplication
@EnableEurekaClient
public class MeuusadoApplication {

	public static void main(String[] args) {
		SpringApplication.run(MeuusadoApplication.class, args);
	}

}
