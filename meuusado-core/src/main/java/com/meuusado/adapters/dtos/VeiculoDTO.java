package com.meuusado.adapters.dtos;

import java.io.Serializable;

import com.meuusado.application.domain.Veiculo;

public class VeiculoDTO implements Serializable {

	private static final long serialVersionUID = 1L;

	private Long idVeiculo;
	
	private Long idUsuario;
	
	private Long idModelo;
	
	private String nomeModelo;
	
	private Long idMarca;
	
	private String nomeMarca;
	
	private String placa;
	
	public VeiculoDTO() {
		super();
		// TODO Auto-generated constructor stub
	}

	public VeiculoDTO(Long idUsuario, Long idModelo) {
		super();
		this.idUsuario = idUsuario;
		this.idModelo = idModelo;
	}
	
	public VeiculoDTO(Long idVeiculo, Long idUsuario, Long idModelo) {
		super();
		this.idVeiculo = idVeiculo;
		this.idUsuario = idUsuario;
		this.idModelo = idModelo;
	}
	
	public VeiculoDTO(Long idVeiculo, Long idUsuario, Long idModelo, String nomeModelo, Long idMarca, String nomeMarca, String placa) {
		super();
		this.idVeiculo = idVeiculo;
		this.idUsuario = idUsuario;
		this.idModelo = idModelo;
		this.nomeModelo = nomeModelo;
		this.idMarca = idMarca;
		this.nomeMarca = nomeMarca;
		this.placa = placa;
	}

	public VeiculoDTO(Veiculo veiculo) {
		super();
		this.idVeiculo = veiculo.idVeiculo();
		this.idUsuario = veiculo.usuario().idUsuario();
		this.idModelo = veiculo.modelo().idModelo();
		this.nomeModelo = veiculo.modelo().nome();
		this.idMarca = veiculo.modelo().marca().idMarca();
		this.nomeMarca = veiculo.modelo().marca().nome();
		this.placa = (veiculo.placa() != null ? veiculo.placa().texto() : "");
	}
	
	public Long getIdVeiculo() {
		return idVeiculo;
	}

	public void setIdVeiculo(Long id) {
		this.idVeiculo = id;
	}

	public Long getIdUsuario() {
		return idUsuario;
	}

	public void setIdUsuario(Long idUsuario) {
		this.idUsuario = idUsuario;
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

	public String getPlaca() {
		return placa;
	}

	public void setPlaca(String placa) {
		this.placa = placa;
	}
	
}
