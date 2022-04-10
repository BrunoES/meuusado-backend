package com.meuusado.application.domain;

public class Modelo {

	private Long idModelo;
	
	private String name;
	
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
