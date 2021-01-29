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
	private String name;
	
	public Marca() {
		super();
	}

	public Marca(Long idMarca, String name) {
		super();
		this.idMarca = idMarca;
		this.name = name;
	}
	
	public Long getIdMarca() {
		return idMarca;
	}

	public void setIdMarca(Long id) {
		this.idMarca = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}
	
	
}
