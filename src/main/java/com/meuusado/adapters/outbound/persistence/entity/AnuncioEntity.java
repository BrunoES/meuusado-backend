package com.meuusado.adapters.outbound.persistence.entity;

import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.Lob;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

import com.fasterxml.jackson.annotation.JsonIgnore;

@Entity
@Table(name = "MU_ANUNCIO")
public class AnuncioEntity {

	@Id
	@GeneratedValue
	@Column(name="ID_ANUNCIO")
	private Long idAnuncio;
	
	@ManyToOne
	@JoinColumn(name="ID_USUARIO")
	private UsuarioEntity usuarioEntity;
	
	@ManyToOne
	@JoinColumn(name="ID_MODELO")
	private ModeloEntity modeloEntity;
	
	@Column(name="TITULO")
	private String titulo;
	
	@Column(name="DESCRICAO")
	private String descricao;
	
	@Column(name="ANO")
	private int ano;
	
	@Column(name="VALOR")
	private float valor;
	
	@Column(name="DATA_CRIACAO")
	private Date dataCriacao;
	
	@Lob
	@Column(name="BASE64_IMG_PRINC_MIN")
	private String base64ImgPrincMin;
	
	@JsonIgnore
	@Column(name="PATH_IMAGEM")
	private String pathImagem;

	public AnuncioEntity() {
		super();
	}

	public AnuncioEntity(Long idAnuncio, UsuarioEntity usuarioEntity, ModeloEntity modeloEntity, String titulo, String descricao, Date dataCriacao,
			String pathImagem) {
		super();
		this.idAnuncio = idAnuncio;
		this.usuarioEntity = usuarioEntity;
		this.modeloEntity = modeloEntity;
		this.titulo = titulo;
		this.descricao = descricao;
		this.dataCriacao = dataCriacao;
		this.pathImagem = pathImagem;
	}
	
	public AnuncioEntity(Long idAnuncio, UsuarioEntity usuarioEntity, ModeloEntity modeloEntity, String titulo, String descricao, Date dataCriacao, String base64ImgPrincMin,
			String pathImagem) {
		super();
		this.idAnuncio = idAnuncio;
		this.usuarioEntity = usuarioEntity;
		this.modeloEntity = modeloEntity;
		this.titulo = titulo;
		this.descricao = descricao;
		this.dataCriacao = dataCriacao;
		this.base64ImgPrincMin = base64ImgPrincMin;
		this.pathImagem = pathImagem;
	}

	public Long getIdAnuncio() {
		return idAnuncio;
	}

	public void setIdAnuncio(Long idAnuncio) {
		this.idAnuncio = idAnuncio;
	}

	public UsuarioEntity getUsuarioEntity() {
		return usuarioEntity;
	}

	public void setUsuarioEntity(UsuarioEntity usuarioEntity) {
		this.usuarioEntity = usuarioEntity;
	}

	public ModeloEntity getModeloEntity() {
		return modeloEntity;
	}

	public void setModeloEntity(ModeloEntity modeloEntity) {
		this.modeloEntity = modeloEntity;
	}

	public String getTitulo() {
		return titulo;
	}

	public void setTitulo(String titulo) {
		this.titulo = titulo;
	}

	public String getDescricao() {
		return descricao;
	}

	public float getValor() {
		return valor;
	}

	public void setValor(float valor) {
		this.valor = valor;
	}

	public void setDescricao(String descricao) {
		this.descricao = descricao;
	}

	public Date getDataCriacao() {
		return dataCriacao;
	}

	public void setDataCriacao(Date dataCriacao) {
		this.dataCriacao = dataCriacao;
	}

	public String getBase64ImgPrincMin() {
		return base64ImgPrincMin;
	}

	public void setBase64ImgPrincMin(String base64ImgPrincMin) {
		this.base64ImgPrincMin = base64ImgPrincMin;
	}

	public String getPathImagem() {
		return pathImagem;
	}

	public void setPathImagem(String pathImagem) {
		this.pathImagem = pathImagem;
	}

	public int getAno() {
		return ano;
	}

	public void setAno(int ano) {
		this.ano = ano;
	}
	
}
