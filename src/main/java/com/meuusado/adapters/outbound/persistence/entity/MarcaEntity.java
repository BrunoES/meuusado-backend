package com.meuusado.adapters.outbound.persistence.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "MU_MARCA")
public class MarcaEntity {

	@Id
	@GeneratedValue
	@Column(name="ID_MARCA")
	private Long idMarca;
	
	@Column(name="NAME")
	private String nome;
	
	public MarcaEntity() {
		super();
	}

	public MarcaEntity(Long idMarca, String nome) {
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

	public void setNome(String nome) {
		this.nome = nome;
	}
	
	
}
