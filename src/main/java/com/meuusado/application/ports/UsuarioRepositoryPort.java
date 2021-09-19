package com.meuusado.application.ports;

import java.util.List;

import com.meuusado.application.domain.Usuario;

public interface UsuarioRepositoryPort {

	List<Usuario> findAll();
	
	Usuario findByEmail(String email);
	
	Usuario findById(Long id);
	
	Usuario save(Usuario usuario);
	
	void delete(Usuario usuario);
	
}
