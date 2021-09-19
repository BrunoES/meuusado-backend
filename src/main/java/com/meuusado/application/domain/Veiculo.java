package com.meuusado.application.domain;

public class Veiculo {

	private Long idVeiculo;
	
	private Usuario usuario;
	
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
