package com.meuusado.adapters.dtos;

import java.io.Serializable;
import java.util.Date;

import com.meuusado.application.domain.Anuncio;

public class AnuncioResumidoDTO implements Serializable {

	private static final long serialVersionUID = 1L;

	private Long idAnuncio;
	
	private Long idUsuario;
	
	private String titulo;
	
	private float valor;
	
	private int ano;
	
	private Date dataCriacao;
	
	private String base64Imagem;
	
	private String base64ImgPrincMin;
	
	public AnuncioResumidoDTO() {
		super();
		// TODO Auto-generated constructor stub
	}

	public AnuncioResumidoDTO(Long idUsuario,  String titulo, int ano, float valor, Date dataCriacao, String base64Imagem) {
		super();
		this.idUsuario = idUsuario;
		this.titulo = titulo;
		this.ano = ano;
		this.valor = valor;
		this.dataCriacao = dataCriacao;
		this.base64Imagem = base64Imagem;
	}
	
	public AnuncioResumidoDTO(Long idAnuncio, Long idUsuario, String titulo, int ano, float valor, Date dataCriacao, String base64Imagem) {
		super();
		this.idAnuncio = idAnuncio;
		this.idUsuario = idUsuario;
		this.titulo = titulo;
		this.ano = ano;
		this.valor = valor;
		this.dataCriacao = dataCriacao;
		this.base64Imagem = base64Imagem;
	}
	
	public AnuncioResumidoDTO(Long idAnuncio, Long idUsuario, String titulo, int ano, float valor, Date dataCriacao, String base64ImgPrincMin, String base64Imagem) {
		super();
		this.idAnuncio = idAnuncio;
		this.idUsuario = idUsuario;
		this.titulo = titulo;
		this.ano = ano;
		this.valor = valor;
		this.dataCriacao = dataCriacao;
		this.base64ImgPrincMin = base64ImgPrincMin;
		this.base64Imagem = base64Imagem;
	}
	
	public AnuncioResumidoDTO(Anuncio anuncio) {
		super();
		this.idAnuncio = anuncio.idAnuncio();
		if(anuncio.usuario() != null)
			this.idUsuario = anuncio.usuario().idUsuario();
		this.titulo = anuncio.titulo();
		this.ano = anuncio.ano();
		this.valor = anuncio.valor();
		this.dataCriacao = anuncio.dataCriacao();
		this.base64Imagem = anuncio.pathImagem();
		if(anuncio.base64ImgPrincMin() != null)
			this.base64ImgPrincMin = anuncio.base64ImgPrincMin();
	}

	public Long getIdAnuncio() {
		return idAnuncio;
	}

	public void setIdAnuncio(Long idAnuncio) {
		this.idAnuncio = idAnuncio;
	}

	public Long getIdUsuario() {
		return idUsuario;
	}

	public void setIdUsuario(Long idUsuario) {
		this.idUsuario = idUsuario;
	}

	public String getTitulo() {
		return titulo;
	}

	public void setTitulo(String titulo) {
		this.titulo = titulo;
	}

	public float getValor() {
		return valor;
	}

	public void setValor(float valor) {
		this.valor = valor;
	}

	public Date getDataCriacao() {
		return dataCriacao;
	}

	public void setDataCriacao(Date dataCriacao) {
		this.dataCriacao = dataCriacao;
	}

	public String getBase64Imagem() {
		return base64Imagem;
	}

	public void setBase64Imagem(String base64Imagem) {
		this.base64Imagem = base64Imagem;
	}

	public String getBase64ImgPrincMin() {
		return base64ImgPrincMin;
	}

	public void setBase64ImgPrincMin(String base64ImgPrincMin) {
		this.base64ImgPrincMin = base64ImgPrincMin;
	}

	public int getAno() {
		return ano;
	}

	public void setAno(int ano) {
		this.ano = ano;
	}
	
}