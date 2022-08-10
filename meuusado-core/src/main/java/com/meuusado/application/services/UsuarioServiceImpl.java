package com.meuusado.application.services;

import java.util.List;

import com.meuusado.application.domain.Usuario;
import com.meuusado.application.ports.UsuarioRepositoryPort;
import com.meuusado.application.ports.UsuarioServicePort;

public class UsuarioServiceImpl implements UsuarioServicePort {

	private final UsuarioRepositoryPort usuarioRepository;
	
	public UsuarioServiceImpl(final UsuarioRepositoryPort usuarioRepository) {
		this.usuarioRepository = usuarioRepository;
	}
	
	@Override
	public List<Usuario> findAll() {
		return usuarioRepository.findAll();
	}

	@Override
	public Usuario findById(Long id) {
		return usuarioRepository.findById(id);
	}

	@Override
	public Usuario save(Usuario Usuario) {
		return usuarioRepository.save(Usuario);
	}

	@Override
	public Usuario update(Usuario Usuario) {
		return usuarioRepository.save(Usuario);
	}

	@Override
	public void delete(Usuario Usuario) {
		usuarioRepository.delete(Usuario);
	}

	
}
