package com.meuusado.application.domain;

public class Veiculo {

	private Long idVeiculo;
	
	private Usuario usuario;
	
	private Modelo modelo;
	
	private Placa placa;

	public Veiculo(Long idVeiculo, String name, Usuario usuario, Modelo modelo) {
		super();
		this.idVeiculo = idVeiculo;
		this.usuario = usuario;
		this.modelo = modelo;
	}

	public Veiculo() {
		// TODO Auto-generated constructor stub
	}

	public Long getIdVeiculo() {
		return idVeiculo;
	}

	public void setIdVeiculo(Long idVeiculo) {
		this.idVeiculo = idVeiculo;
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

	public Placa getPlaca() {
		return placa;
	}

	public void setPlaca(Placa placa) {
		this.placa = placa;
	}
	
}
