package com.meuusado.entities;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

@Entity
@Table(name = "MU_VEICULO")
public class Veiculo {

	@Id
	@GeneratedValue
	@Column(name="ID_VEICULO")
	private Long idVeiculo;
	
	@ManyToOne
	@JoinColumn(name="ID_USUARIO")
	private Usuario usuario;
	
	@ManyToOne
	@JoinColumn(name="ID_MODELO")
	private Modelo modelo;

	public Veiculo() {
		super();
	}

	public Veiculo(Long idVeiculo, String name, Usuario usuario, Modelo modelo) {
		super();
		this.idVeiculo = idVeiculo;
		this.usuario = usuario;
		this.modelo = modelo;
	}
	
	public Long getIdVeiculo() {
		return idVeiculo;
	}

	public void setIdVeiculo(Long id) {
		this.idVeiculo = id;
	}

	public Usuario getUsuario() {
		return usuario;
	}

	public void setUsuario(Usuario usuario) {
		this.usuario = usuario;
	}

	public Modelo getModelo() {
		return modelo;
	}

	public void setModelo(Modelo modelo) {
		this.modelo = modelo;
	}
	
}
