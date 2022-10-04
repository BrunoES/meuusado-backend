package com.meuusado.adapters.configurations;

import com.meuusado.application.domain.Anuncio;
import com.meuusado.application.ports.AnuncioRepositoryPort;
import com.meuusado.application.ports.MessagingServicePort;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;

import com.meuusado.MeuusadoApplication;
import com.meuusado.adapters.outbound.persistence.PostgresMarcaRepository;
import com.meuusado.adapters.outbound.persistence.PostgresModeloRepository;
import com.meuusado.adapters.outbound.persistence.PostgresUsuarioRepository;
import com.meuusado.adapters.outbound.persistence.PostgresVeiculoRepository;
import com.meuusado.application.services.AnuncioServiceImpl;
import com.meuusado.application.services.MarcaServiceImpl;
import com.meuusado.application.services.MessagingServiceImpl;
import com.meuusado.application.services.ModeloServiceImpl;
import com.meuusado.application.services.UsuarioServiceImpl;
import com.meuusado.application.services.VeiculoServiceImpl;

@Configuration
@ComponentScan(basePackageClasses = MeuusadoApplication.class)
public class BeanConfiguration {

	@Value("${kafka.address:localhost:9092}")
	private String kafkaAddress;
	
    @Bean
    public AnuncioServiceImpl anuncioServiceImpl(AnuncioRepositoryPort anuncioRepositoryPort, MessagingServicePort<Anuncio> messagingServicePort) {
        return new AnuncioServiceImpl(anuncioRepositoryPort, messagingServicePort);
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
    public MessagingServiceImpl<Anuncio> messagingServiceImpl() {
    	return new MessagingServiceImpl<Anuncio>(kafkaAddress);
    }
    
    @Bean
    public ModelMapper modelMapper() {
        return new ModelMapper();
    }
    
    @Bean
	public PasswordEncoder getPasswordEncoder() {
		BCryptPasswordEncoder encoder = new BCryptPasswordEncoder();
		return encoder;
	}
    
}