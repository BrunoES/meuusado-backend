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
		//return usuarioRepository.findAll().stream().map(x -> modelMapper.map(x, Usuario.class)).collect(Collectors.toList());
		return usuarioRepository.findAll().stream().map(x -> x.toDomain()).collect(Collectors.toList());
	}

	@Override
	public Usuario findByEmail(String email) {
		UsuarioEntity usuarioEntity = usuarioRepository.findByEmail(email); 
		//return modelMapper.map(usuarioEntity, Usuario.class);
		return usuarioEntity.toDomain();
	}
	
	@Override
	public Usuario findById(Long id) {
		UsuarioEntity usuarioEntity = usuarioRepository.findById(id).orElse(null);
		return usuarioEntity.toDomain();
	}

	@Override
	public Usuario save(Usuario usuario) {
		UsuarioEntity usuarioEntity = new UsuarioEntity();
		usuarioEntity.setEmail(usuario.email());
		usuarioEntity.setNome(usuario.nome());
		usuarioEntity.setPassword(usuario.password());
		return usuarioRepository.save(usuarioEntity).toDomain();
	}

	@Override
	public void delete(Usuario usuario) {
		UsuarioEntity usuarioEntity = modelMapper.map(usuario, UsuarioEntity.class);
		usuarioRepository.delete(usuarioEntity);
	}

}
