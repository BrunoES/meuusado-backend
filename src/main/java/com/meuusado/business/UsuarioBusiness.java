package com.meuusado.business;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.meuusado.dtos.UsuarioDTO;
import com.meuusado.entities.Usuario;
import com.meuusado.repository.UsuarioRepository;

@Component
public class UsuarioBusiness {

	@Autowired
	private UsuarioRepository usuarioRepository;
	
	public List<Usuario> findAll() {
		return usuarioRepository.findAll();
	}
	
	public Usuario findById(Long id) {
		return usuarioRepository.findById(id).orElse(null);
	}
	
	public Usuario save(UsuarioDTO usuarioDto) {
		Usuario usuario = dtoToEntity(usuarioDto);
		return usuarioRepository.save(usuario);
	}
	
	public void delete(Long id) {
		usuarioRepository.findById(id).ifPresent(usuario -> {
			usuarioRepository.delete(usuario);
		});
	}
	
	public Usuario dtoToEntity(UsuarioDTO usuarioDto) {
		Usuario usuario = new Usuario();
		usuario.setIdUsuario(usuarioDto.getIdUsuario());
		usuario.setNome(usuarioDto.getNome());
		usuario.setEmail(usuarioDto.getEmail());
		usuario.setPassword(usuarioDto.getPassword());
		return usuario;
	}
}
