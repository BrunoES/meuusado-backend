package com.meuusado.adapters.outbound.persistence.entity;

import java.util.Objects;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

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
	
	@ManyToOne
	@JoinColumn(name="ID_USUARIO")
	private UsuarioEntity usuario;
	
	@ManyToOne
	@JoinColumn(name="ID_MODELO")
	private ModeloEntity modelo;

	public VeiculoEntity() {
		super();
	}

	public VeiculoEntity(Long idVeiculo, String name, UsuarioEntity usuario, ModeloEntity modelo) {
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
