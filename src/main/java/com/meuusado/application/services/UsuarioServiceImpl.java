package com.meuusado.application.services;

import java.util.List;

import com.meuusado.application.domain.Usuario;
import com.meuusado.application.ports.UsuarioRepositoryPort;
import com.meuusado.application.ports.UsuarioServicePort;

public class UsuarioServiceImpl implements UsuarioServicePort {

	private final UsuarioRepositoryPort UsuarioRepository;
	
	public UsuarioServiceImpl(final UsuarioRepositoryPort UsuarioRepository) {
		this.UsuarioRepository = UsuarioRepository;
	}
	
	@Override
	public List<Usuario> findAll() {
		return UsuarioRepository.findAll();
	}

	@Override
	public Usuario findById(Long id) {
		return UsuarioRepository.findById(id);
	}

	@Override
	public Usuario save(Usuario Usuario) {
		return UsuarioRepository.save(Usuario);
	}

	@Override
	public Usuario update(Usuario Usuario) {
		return UsuarioRepository.save(Usuario);
	}

	@Override
	public void delete(Usuario Usuario) {
		UsuarioRepository.delete(Usuario);
	}

	
}
