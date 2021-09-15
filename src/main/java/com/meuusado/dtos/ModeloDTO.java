package com.meuusado.dtos;

import java.io.Serializable;

import com.meuusado.entities.Modelo;

public class ModeloDTO implements Serializable {

	private static final long serialVersionUID = 1L;

	private Long idModelo;
	
	private String nomeModelo;
	
	private Long idMarca;
	
	private String nomeMarca;
	
	public ModeloDTO() {
		super();
		// TODO Auto-generated constructor stub
	}

	public ModeloDTO(String nomeModelo, Long idMarca) {
		super();
		this.nomeModelo = nomeModelo;
		this.idMarca = idMarca;
	}
	
	public ModeloDTO(Long idUsuario, String nomeModelo, Long idMarca, String nomeMarca) {
		super();
		this.nomeModelo = nomeModelo;
		this.idMarca = idMarca;
		this.nomeMarca = nomeMarca;
	}
	
	public ModeloDTO(Long idModelo, Long idUsuario, String nomeModelo, Long idMarca) {
		super();
		this.idModelo = idModelo;
		this.nomeModelo = nomeModelo;
		this.idMarca = idMarca;
	}
	
	public ModeloDTO(Long idModelo, Long idUsuario, String nomeModelo, Long idMarca, String nomeMarca) {
		super();
		this.idModelo = idModelo;
		this.nomeModelo = nomeModelo;
		this.idMarca = idMarca;
		this.nomeMarca = nomeMarca;
	}

	public ModeloDTO(Modelo modelo) {
		super();
		this.idModelo = modelo.getIdModelo();
		this.nomeModelo = modelo.getName();
		this.idMarca = modelo.getMarca().getIdMarca();
		this.nomeMarca = modelo.getMarca().getNome();
	}
	
	public Long getIdModelo() {
		return idModelo;
	}

	public void setIdModelo(Long idModelo) {
		this.idModelo = idModelo;
	}
	
	public String getNomeModelo() {
		return nomeModelo;
	}

	public void setNomeModelo(String nomeModelo) {
		this.nomeModelo = nomeModelo;
	}

	public Long getIdMarca() {
		return idMarca;
	}

	public void setIdMarca(Long idMarca) {
		this.idMarca = idMarca;
	}

	public String getNomeMarca() {
		return nomeMarca;
	}

	public void setNomeMarca(String nomeMarca) {
		this.nomeMarca = nomeMarca;
	}

}
