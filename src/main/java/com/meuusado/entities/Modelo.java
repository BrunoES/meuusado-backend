package com.meuusado.entities;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

@Entity
@Table(name = "MU_MODELO")
public class Modelo {

	@Id
	@GeneratedValue
	@Column(name="ID_MODELO")
	private Long idModelo;
	
	@Column(name="NAME")
	private String name;
	
	@ManyToOne
	@JoinColumn(name="ID_MARCA")
	private Marca marca;
	
	public Modelo() {
		super();
	}

	public Modelo(Long idModelo, String name, Marca marca) {
		super();
		this.idModelo = idModelo;
		this.name = name;
		this.marca = marca;
	}
	
	public Long getIdModelo() {
		return idModelo;
	}

	public void setIdModelo(Long id) {
		this.idModelo = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public Marca getMarca() {
		return marca;
	}

	public void setMarca(Marca marca) {
		this.marca = marca;
	}
	
}
