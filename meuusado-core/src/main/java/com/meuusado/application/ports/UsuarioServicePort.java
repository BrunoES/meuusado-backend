package com.meuusado.application.ports;

import java.util.List;

import com.meuusado.application.domain.Usuario;

public interface UsuarioServicePort {
	
	List<Usuario> findAll();
	
	Usuario findById(Long id);
	
	Usuario save(Usuario usuario);
	
	Usuario update(Usuario usuario);
	
	void delete(Usuario usuario);
	
}
