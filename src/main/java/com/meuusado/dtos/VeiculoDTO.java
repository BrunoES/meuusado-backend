package com.meuusado.dtos;

import java.io.Serializable;

import com.meuusado.entities.Veiculo;

public class VeiculoDTO implements Serializable {

	private static final long serialVersionUID = 1L;

	private Long idVeiculo;
	
	private Long idUsuario;
	
	private Long idModelo;
	
	private String nomeModelo;
	
	private Long idMarca;
	
	private String nomeMarca;
	
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
	
	public VeiculoDTO(Long idVeiculo, Long idUsuario, Long idModelo, String nomeModelo, Long idMarca, String nomeMarca) {
		super();
		this.idVeiculo = idVeiculo;
		this.idUsuario = idUsuario;
		this.idModelo = idModelo;
		this.nomeModelo = nomeModelo;
		this.idMarca = idMarca;
		this.nomeMarca = nomeMarca;
	}

	public VeiculoDTO(Veiculo veiculo) {
		super();
		this.idVeiculo = veiculo.getIdVeiculo();
		this.idUsuario = veiculo.getUsuario().getIdUsuario();
		this.idModelo = veiculo.getModelo().getIdModelo();
		this.nomeModelo = veiculo.getModelo().getName();
		this.idMarca = veiculo.getModelo().getMarca().getIdMarca();
		this.nomeMarca = veiculo.getModelo().getMarca().getName();
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

}
