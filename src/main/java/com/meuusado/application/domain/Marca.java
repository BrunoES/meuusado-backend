package com.meuusado.application.domain;

public class Marca {

	private Long idMarca;
	
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
