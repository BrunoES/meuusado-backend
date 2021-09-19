package com.meuusado.adapters.configurations;

import org.modelmapper.ModelMapper;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;

import com.meuusado.MeuusadoApplication;
import com.meuusado.adapters.outbound.persistence.PostgresAnuncioRepository;
import com.meuusado.adapters.outbound.persistence.PostgresMarcaRepository;
import com.meuusado.adapters.outbound.persistence.PostgresModeloRepository;
import com.meuusado.adapters.outbound.persistence.PostgresUsuarioRepository;
import com.meuusado.adapters.outbound.persistence.PostgresVeiculoRepository;
import com.meuusado.application.services.AnuncioServiceImpl;
import com.meuusado.application.services.MarcaServiceImpl;
import com.meuusado.application.services.ModeloServiceImpl;
import com.meuusado.application.services.UsuarioServiceImpl;
import com.meuusado.application.services.VeiculoServiceImpl;

@Configuration
@ComponentScan(basePackageClasses = MeuusadoApplication.class)
public class BeanConfiguration {

    @Bean
    AnuncioServiceImpl anuncioServiceImpl(PostgresAnuncioRepository repository) {
        return new AnuncioServiceImpl(repository);
    }
    
    @Bean
    MarcaServiceImpl marcaServiceImpl(PostgresMarcaRepository repository) {
        return new MarcaServiceImpl(repository);
    }
    
    @Bean
    ModeloServiceImpl modeloServiceImpl(PostgresModeloRepository repository) {
        return new ModeloServiceImpl(repository);
    }
    
    @Bean
    UsuarioServiceImpl usuarioServiceImpl(PostgresUsuarioRepository repository) {
        return new UsuarioServiceImpl(repository);
    }
    
    @Bean
    VeiculoServiceImpl veiculoServiceImpl(PostgresVeiculoRepository repository) {
        return new VeiculoServiceImpl(repository);
    }

    @Bean
    public ModelMapper modelMapper() {
        return new ModelMapper();
    }
}