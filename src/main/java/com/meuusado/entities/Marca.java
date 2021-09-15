package com.meuusado.entities;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "MU_MARCA")
public class Marca {

	@Id
	@GeneratedValue
	@Column(name="ID_MARCA")
	private Long idMarca;
	
	@Column(name="NAME")
	private String nome;
	
	public Marca() {
		super();
	}

	public Marca(Long idMarca, String nome) {
		super();
		this.idMarca = idMarca;
		this.nome = nome;
	}
	
	public Long getIdMarca() {
		return idMarca;
	}

	public void setIdMarca(Long id) {
		this.idMarca = id;
	}

	public String getNome() {
		return nome;
	}

	public void setName(String nome) {
		this.nome = nome;
	}
	
	
}
