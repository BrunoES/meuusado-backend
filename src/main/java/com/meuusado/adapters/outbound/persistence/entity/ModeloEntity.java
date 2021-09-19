package com.meuusado.adapters.outbound.persistence.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

@Entity
@Table(name = "MU_MODELO")
public class ModeloEntity {

	@Id
	@GeneratedValue
	@Column(name="ID_MODELO")
	private Long idModelo;
	
	@Column(name="NAME")
	private String name;
	
	@ManyToOne
	@JoinColumn(name="ID_MARCA")
	private MarcaEntity marca;
	
	public ModeloEntity() {
		super();
	}

	public ModeloEntity(Long idModelo, String name, MarcaEntity marca) {
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

	public MarcaEntity getMarca() {
		return marca;
	}

	public void setMarca(MarcaEntity marca) {
		this.marca = marca;
	}
	
}
