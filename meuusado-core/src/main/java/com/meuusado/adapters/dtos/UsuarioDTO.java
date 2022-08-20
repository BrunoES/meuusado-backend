package com.meuusado.adapters.dtos;

import java.io.Serializable;

import com.meuusado.application.domain.Usuario;

public class UsuarioDTO implements Serializable {

	private static final long serialVersionUID = 1L;

	private Long idUsuario;
	
	private String nome;
	
	private String email;
	
	private String password;

	public UsuarioDTO() {
		super();
		// TODO Auto-generated constructor stub
	}

	public UsuarioDTO(String nome, String email, String password) {
		super();
		this.nome = nome;
		this.email = email;
		this.password = password;
	}

	
	public UsuarioDTO(Long idUsuario, String nome, String email, String password) {
		super();
		this.idUsuario = idUsuario;
		this.nome = nome;
		this.email = email;
		this.password = password;
	}

	public UsuarioDTO(Usuario usuario) {
		super();
		this.idUsuario = usuario.idUsuario();
		this.nome = usuario.nome();
		this.email = usuario.email();
		this.password = usuario.password();
	}
	
	public Long getIdUsuario() {
		return idUsuario;
	}

	public void setIdUsuario(Long id) {
		this.idUsuario = id;
	}

	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
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
