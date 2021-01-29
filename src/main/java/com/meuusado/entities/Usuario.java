package com.meuusado.entities;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "MU_USUARIO")
public class Usuario {

	@Id
	@GeneratedValue
	@Column(name="ID_USUARIO")
	private Long idUsuario;
	
	@Column(name="NAME")
	private String name;
	
	@Column(name="EMAIL")
	private String email;
	
	@Column(name="PASSWORD")
	private String password;

	public Usuario() {
		super();
	}

	public Usuario(Long idUsuario, String name, String email, String password) {
		super();
		this.idUsuario = idUsuario;
		this.name = name;
		this.email = email;
		this.password = password;
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
