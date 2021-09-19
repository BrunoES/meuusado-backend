package com.meuusado.application.domain;

public class Usuario {

	private Long idUsuario;
	
	private String nome;
	
	private String email;
	
	private String password;

	public Usuario() {
		super();
	}

	public Usuario(Long idUsuario, String nome, String email, String password) {
		super();
		this.idUsuario = idUsuario;
		this.nome = nome;
		this.email = email;
		this.password = password;
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

	public void setNome(String name) {
		this.nome = name;
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
