package com.meuusado.dtos;

import java.io.Serializable;

import com.meuusado.entities.Usuario;

public class UsuarioDTO implements Serializable {

	private static final long serialVersionUID = 1L;

	private Long idUsuario;
	
	private String name;
	
	private String email;
	
	private String password;

	public UsuarioDTO() {
		super();
		// TODO Auto-generated constructor stub
	}

	public UsuarioDTO(String name, String email, String password) {
		super();
		this.name = name;
		this.email = email;
		this.password = password;
	}

	
	public UsuarioDTO(Long idUsuario, String name, String email, String password) {
		super();
		this.idUsuario = idUsuario;
		this.name = name;
		this.email = email;
		this.password = password;
	}

	public UsuarioDTO(Usuario usuario) {
		super();
		this.idUsuario = usuario.getIdUsuario();
		this.name = usuario.getName();
		this.email = usuario.getEmail();
		this.password = usuario.getPassword();
	}
	
	public Long getIdUsuario() {
		return idUsuario;
	}

	public void setIdUsuario(Long id) {
		this.idUsuario = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}
	
}
