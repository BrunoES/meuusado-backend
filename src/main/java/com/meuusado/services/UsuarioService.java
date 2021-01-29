package com.meuusado.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.meuusado.business.UsuarioBusiness;
import com.meuusado.dtos.UsuarioDTO;
import com.meuusado.entities.Usuario;

@Service
public class UsuarioService {

	@Autowired
	private UsuarioBusiness usuarioBusiness;
	
	public List<Usuario> findAll() {
		return usuarioBusiness.findAll();
	}
	
	public Usuario findById(Long id) {
		return usuarioBusiness.findById(id);
	}
	
	public Usuario save(UsuarioDTO usuarioDto) {
		return usuarioBusiness.save(usuarioDto);
	}
	
	public Usuario update(UsuarioDTO usuarioDto) {
		return usuarioBusiness.save(usuarioDto);
	}
	
	public void delete(Long id) {
		usuarioBusiness.delete(id);
	}
	
}
