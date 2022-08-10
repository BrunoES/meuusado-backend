package com.meuusado.adapters.configurations;

import com.meuusado.application.ports.AnuncioFotosRepositoryPort;
import com.meuusado.application.ports.AnuncioRepositoryPort;
import org.modelmapper.ModelMapper;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;

import com.meuusado.MeuusadoApplication;
import com.meuusado.adapters.outbound.persistence.PostgresMarcaRepository;
import com.meuusado.adapters.outbound.persistence.PostgresModeloRepository;
import com.meuusado.adapters.outbound.persistence.PostgresUsuarioRepository;
import com.meuusado.adapters.outbound.persistence.PostgresVeiculoRepository;
import com.meuusado.application.services.AnuncioServiceImpl;
import com.meuusado.application.services.LoginServiceImpl;
import com.meuusado.application.services.MarcaServiceImpl;
import com.meuusado.application.services.ModeloServiceImpl;
import com.meuusado.application.services.UsuarioServiceImpl;
import com.meuusado.application.services.VeiculoServiceImpl;

@Configuration
@ComponentScan(basePackageClasses = MeuusadoApplication.class)
public class BeanConfiguration {

    @Bean
    public AnuncioServiceImpl anuncioServiceImpl(AnuncioRepositoryPort anuncioRepositoryPort, AnuncioFotosRepositoryPort anuncioFotosRepositoryPort) {
        return new AnuncioServiceImpl(anuncioRepositoryPort, anuncioFotosRepositoryPort);
    }
    
    @Bean
    public MarcaServiceImpl marcaServiceImpl(PostgresMarcaRepository repository) {
        return new MarcaServiceImpl(repository);
    }
    
    @Bean
    public ModeloServiceImpl modeloServiceImpl(PostgresModeloRepository repository) {
        return new ModeloServiceImpl(repository);
    }
    
    @Bean
    public UsuarioServiceImpl usuarioServiceImpl(PostgresUsuarioRepository repository) {
        return new UsuarioServiceImpl(repository);
    }
    
    @Bean
    public VeiculoServiceImpl veiculoServiceImpl(PostgresVeiculoRepository repository) {
        return new VeiculoServiceImpl(repository);
    }

    @Bean
    public LoginServiceImpl loginServiceImpl(PostgresUsuarioRepository repository) {
        return new LoginServiceImpl(repository);
    }
    
    @Bean
    public ModelMapper modelMapper() {
        return new ModelMapper();
    }
}