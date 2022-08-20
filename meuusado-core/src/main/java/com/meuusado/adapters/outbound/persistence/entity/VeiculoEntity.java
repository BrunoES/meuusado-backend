package com.meuusado.adapters.outbound.persistence.entity;

import java.util.Objects;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.persistence.Transient;

import com.meuusado.application.domain.Cor;
import com.meuusado.application.domain.Placa;
import com.meuusado.application.domain.Veiculo;

@Entity
@Table(name = "MU_VEICULO")
public class VeiculoEntity {

	@Id
	@GeneratedValue
	@Column(name="ID_VEICULO")
	private Long idVeiculo;
	
	@Column(name="ID_USUARIO")
	private Long idUsuario;
	
	@Transient
	private UsuarioEntity usuario;
	
	@Column(name="ID_MODELO")
	private Long idModelo;
	
	@Transient
	private ModeloEntity modelo;

	public VeiculoEntity() {
		super();
	}

	public VeiculoEntity(Long idVeiculo, String name, Long idUsuario, Long idModelo) {
		super();
		this.idVeiculo = idVeiculo;
		this.idUsuario = idUsuario;
		this.idModelo = idModelo;
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

	public UsuarioEntity getUsuario() {
		return usuario;
	}

	public void setUsuario(UsuarioEntity usuario) {
		this.usuario = usuario;
	}

	public ModeloEntity getModelo() {
		return modelo;
	}

	public void setModelo(ModeloEntity modelo) {
		this.modelo = modelo;
	}
	
	public Veiculo toDomain() {
		return new Veiculo(this.idVeiculo,
				Objects.isNull(this.usuario) ? null : this.usuario.toDomain(),
				Objects.isNull(this.modelo) ? null : this.modelo.toDomain(),
				new Placa("", new Cor("Azul")));
	}
	
}
