package com.meuusado.adapters.outbound.persistence.entity;

import java.util.Objects;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.persistence.Transient;

import com.meuusado.application.domain.Modelo;

@Entity
@Table(name = "MU_MODELO")
public class ModeloEntity {

	@Id
	@GeneratedValue
	@Column(name="ID_MODELO")
	private Long idModelo;
	
	@Column(name="NAME")
	private String name;
	
	@Column(name="ID_MARCA")
	private Long idMarca;
	
	@Transient
	private MarcaEntity marca;
	
	public ModeloEntity() {
		super();
	}

	public ModeloEntity(Long idModelo, String name, Long idMarca) {
		super();
		this.idModelo = idModelo;
		this.name = name;
		this.idMarca = idMarca;
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

	public Long getIdMarca() {
		return idMarca;
	}

	public void setIdMarca(Long idMarca) {
		this.idMarca = idMarca;
	}

	public MarcaEntity getMarca() {
		return marca;
	}

	public void setMarca(MarcaEntity marca) {
		this.marca = marca;
	}

	public Modelo toDomain() {
		return new Modelo(this.idModelo,
				this.name,
				Objects.isNull(this.marca) ? null : this.marca.toDomain());
	}
	
}
