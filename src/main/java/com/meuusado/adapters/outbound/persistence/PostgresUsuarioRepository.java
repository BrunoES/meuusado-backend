package com.meuusado.adapters.outbound.persistence;

import java.util.List;
import java.util.stream.Collectors;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Primary;
import org.springframework.stereotype.Component;

import com.meuusado.adapters.outbound.persistence.entity.UsuarioEntity;
import com.meuusado.application.domain.Usuario;
import com.meuusado.application.ports.UsuarioRepositoryPort;

@Component
@Primary
public class PostgresUsuarioRepository implements UsuarioRepositoryPort {

	@Autowired
	private SpringDataPostgresUsuarioRepository usuarioRepository;
	
	@Autowired
    private ModelMapper modelMapper;
	
	@Override
	public List<Usuario> findAll() {
		return usuarioRepository.findAll().stream().map(x -> modelMapper.map(x, Usuario.class)).collect(Collectors.toList());
	}

	@Override
	public Usuario findByEmail(String email) {
		return usuarioRepository.findByEmail(email);
	}
	
	@Override
	public Usuario findById(Long id) {
		UsuarioEntity UsuarioEntity = usuarioRepository.findById(id).orElse(null);
		return modelMapper.map(UsuarioEntity, Usuario.class);
	}

	@Override
	public Usuario save(Usuario usuario) {
		UsuarioEntity UsuarioEntity = modelMapper.map(usuario, UsuarioEntity.class);
		return modelMapper.map(usuarioRepository.save(UsuarioEntity), Usuario.class);
	}

	@Override
	public void delete(Usuario usuario) {
		UsuarioEntity UsuarioEntity = modelMapper.map(usuario, UsuarioEntity.class);
		usuarioRepository.delete(UsuarioEntity);
	}

}
