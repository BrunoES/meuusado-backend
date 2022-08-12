package com.meuusado.meuusadogateway;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;

@SpringBootApplication
@EnableEurekaClient
public class MeuusadoGatewayApplication {

	public static void main(String[] args) {
		SpringApplication.run(MeuusadoGatewayApplication.class, args);
	}

}
