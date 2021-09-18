package com.meuusado.adapters.configurations;

import org.modelmapper.ModelMapper;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;

import com.meuusado.MeuusadoApplication;
import com.meuusado.adapters.outbound.persistence.PostgresAnuncioRepository;
import com.meuusado.application.services.AnuncioServiceImpl;

@Configuration
@ComponentScan(basePackageClasses = MeuusadoApplication.class)
public class BeanConfiguration {

    @Bean
    AnuncioServiceImpl emailServiceImpl(PostgresAnuncioRepository repository) {
        return new AnuncioServiceImpl(repository);
    }

    @Bean
    public ModelMapper modelMapper() {
        return new ModelMapper();
    }
}