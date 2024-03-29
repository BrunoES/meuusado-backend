package com.meuusado.adapters.outbound.persistence.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;

import com.meuusado.application.domain.Usuario;

@Entity
@Table(name = "MU_USUARIO")
public class UsuarioEntity {

	@Id
	@GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "SGMU_USUARIO")
    @SequenceGenerator(name =  "SGMU_USUARIO",sequenceName = "SMU_USUARIO")
	@Column(name="ID_USUARIO")
	private Long idUsuario;
	
	@Column(name="NOME")
	private String nome;
	
	@Column(name="EMAIL")
	private String email;
	
	@Column(name="PASSWORD")
	private String password;

	public UsuarioEntity() {
		super();
	}

	public UsuarioEntity(Long idUsuario, String nome, String email, String password) {
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
	
	public Usuario toDomain() {
		return new Usuario(this.idUsuario, this.nome, this.email, this.password);
	}
	
}
