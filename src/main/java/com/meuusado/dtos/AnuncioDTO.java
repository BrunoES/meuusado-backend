package com.meuusado.dtos;

import java.io.Serializable;
import java.util.Date;

import com.meuusado.entities.Anuncio;

public class AnuncioDTO implements Serializable {

	private static final long serialVersionUID = 1L;

	private Long idAnuncio;
	
	private Long idUsuario;
	
	private Long idModelo;
	
	private String nomeModelo;
	
	private String titulo;
	
	private String descricao;
	
	private float valor;
	
	private Date dataCriacao;
	
	private String base64Imagem;
	
	public AnuncioDTO() {
		super();
		// TODO Auto-generated constructor stub
	}

	public AnuncioDTO(Long idUsuario, Long idModelo, String titulo, String descricao, float valor, Date dataCriacao,
			String base64Imagem) {
		super();
		this.idUsuario = idUsuario;
		this.idModelo = idModelo;
		this.titulo = titulo;
		this.descricao = descricao;
		this.valor = valor;
		this.dataCriacao = dataCriacao;
		this.base64Imagem = base64Imagem;
	}
	
	public AnuncioDTO(Long idUsuario, Long idModelo, String nomeModelo, String titulo, String descricao, float valor, Date dataCriacao,
			String base64Imagem) {
		super();
		this.idUsuario = idUsuario;
		this.idModelo = idModelo;
		this.nomeModelo = nomeModelo;
		this.titulo = titulo;
		this.descricao = descricao;
		this.valor = valor;
		this.dataCriacao = dataCriacao;
		this.base64Imagem = base64Imagem;
	}
	
	public AnuncioDTO(Long idAnuncio, Long idUsuario, Long idModelo, String nomeModelo, String titulo, String descricao, float valor, Date dataCriacao,
			String base64Imagem) {
		super();
		this.idAnuncio = idAnuncio;
		this.idUsuario = idUsuario;
		this.idModelo = idModelo;
		this.nomeModelo = nomeModelo;
		this.titulo = titulo;
		this.descricao = descricao;
		this.valor = valor;
		this.dataCriacao = dataCriacao;
		this.base64Imagem = base64Imagem;
	}
	
	public AnuncioDTO(Anuncio anuncio) {
		super();
		this.setIdAnuncio(anuncio.getIdAnuncio());
		this.setIdUsuario(anuncio.getUsuario().getIdUsuario());
		this.setIdModelo(anuncio.getModelo() != null ? anuncio.getModelo().getIdModelo() : null);
		this.setNomeModelo(anuncio.getModelo() != null ? anuncio.getModelo().getName() : "");
		this.setTitulo(anuncio.getTitulo());
		this.setDescricao(anuncio.getDescricao());
		this.setValor(anuncio.getValor());
		this.setDataCriacao(anuncio.getDataCriacao());
		this.setBase64Imagem(anuncio.getBase64ImgPrincMin());
		//this.setImagem
		
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

	public Long getIdModelo() {
		return idModelo;
	}

	public void setIdModelo(Long idModelo) {
		this.idModelo = idModelo;
	}

	public String getTitulo() {
		return titulo;
	}

	public String getNomeModelo() {
		return nomeModelo;
	}

	public void setNomeModelo(String nomeModelo) {
		this.nomeModelo = nomeModelo;
	}

	public void setTitulo(String titulo) {
		this.titulo = titulo;
	}

	public String getDescricao() {
		return descricao;
	}

	public void setDescricao(String descricao) {
		this.descricao = descricao;
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

}
