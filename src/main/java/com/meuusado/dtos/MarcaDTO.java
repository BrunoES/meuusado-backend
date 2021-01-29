package com.meuusado.dtos;

import java.io.Serializable;

import com.meuusado.entities.Marca;

public class MarcaDTO implements Serializable {

	private static final long serialVersionUID = 1L;

	private Long idMarca;
	
	private String name;
	
	public MarcaDTO() {
		super();
		// TODO Auto-generated constructor stub
	}

	public MarcaDTO(String name) {
		super();
		this.name = name;
	}
	
	public MarcaDTO(Long idMarca, String name) {
		super();
		this.idMarca = idMarca;
		this.name = name;
	}
	
	public MarcaDTO(Marca marca) {
		this.idMarca = marca.getIdMarca();
		this.name = marca.getName();
	}

	public Long getIdMarca() {
		return idMarca;
	}

	public void setIdMarca(Long idMarca) {
		this.idMarca = idMarca;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

}
