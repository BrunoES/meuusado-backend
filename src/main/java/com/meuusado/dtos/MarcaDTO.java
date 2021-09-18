package com.meuusado.dtos;

import java.io.Serializable;

import com.meuusado.entities.Marca;

public class MarcaDTO implements Serializable {

	private static final long serialVersionUID = 1L;

	private Long idMarca;
	
	private String nome;
	
	public MarcaDTO() {
		super();
		// TODO Auto-generated constructor stub
	}

	public MarcaDTO(String nome) {
		super();
		this.nome = nome;
	}
	
	public MarcaDTO(Long idMarca, String nome) {
		super();
		this.idMarca = idMarca;
		this.nome = nome;
	}
	
	public MarcaDTO(Marca marca) {
		this.idMarca = marca.getIdMarca();
		this.nome = marca.getNome();
	}

	public Long getIdMarca() {
		return idMarca;
	}

	public void setIdMarca(Long idMarca) {
		this.idMarca = idMarca;
	}

	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}

}