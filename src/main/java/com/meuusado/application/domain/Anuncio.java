package com.meuusado.application.domain;

import java.util.Date;
import java.util.List;

public class Anuncio {

	private Long idAnuncio;
	
	private Usuario usuario;
	
	private Modelo modelo;
	
	private String titulo;
	
	private String descricao;
	
	private int ano;
	
	private float valor;
	
	private Date dataCriacao;
	
	private String base64ImgPrincMin;
	
	private String pathImagem;
	
	private List<AnuncioFotos> listAnuncioFotos;

	public Anuncio() {
		super();
	}

	public Anuncio(Long idAnuncio, Usuario usuario, Modelo modelo, String titulo, String descricao, Date dataCriacao,
			String pathImagem) {
		super();
		this.idAnuncio = idAnuncio;
		this.usuario = usuario;
		this.modelo = modelo;
		this.titulo = titulo;
		this.descricao = descricao;
		this.dataCriacao = dataCriacao;
		this.pathImagem = pathImagem;
	}
	
	public Anuncio(Long idAnuncio, Usuario usuario, Modelo modelo, String titulo, String descricao, Date dataCriacao, String base64ImgPrincMin,
			String pathImagem) {
		super();
		this.idAnuncio = idAnuncio;
		this.usuario = usuario;
		this.modelo = modelo;
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

	public List<AnuncioFotos> getListAnuncioFotos() {
		return listAnuncioFotos;
	}

	public void setListAnuncioFotos(List<AnuncioFotos> listAnuncioFotos) {
		this.listAnuncioFotos = listAnuncioFotos;
	}
	
}
