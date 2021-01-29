package com.meuusado.dtos;

import java.io.Serializable;
import java.util.Date;

import com.meuusado.entities.Anuncio;

public class AnuncioDTO implements Serializable {

	private static final long serialVersionUID = 1L;

	private Long idAnuncio;
	
	private Long idUsuario;
	
	private Long idVeiculo;
	
	private String titulo;
	
	private String descricao;
	
	private Date dataCriacao;
	
	private String base64Imagem;
	
	public AnuncioDTO() {
		super();
		// TODO Auto-generated constructor stub
	}

	public AnuncioDTO(Long idUsuario, Long idVeiculo, String titulo, String descricao, Date dataCriacao,
			String base64Imagem) {
		super();
		this.idUsuario = idUsuario;
		this.idVeiculo = idVeiculo;
		this.titulo = titulo;
		this.descricao = descricao;
		this.dataCriacao = dataCriacao;
		this.base64Imagem = base64Imagem;
	}
	
	public AnuncioDTO(Long idAnuncio, Long idUsuario, Long idVeiculo, String titulo, String descricao, Date dataCriacao,
			String base64Imagem) {
		super();
		this.idAnuncio = idAnuncio;
		this.idUsuario = idUsuario;
		this.idVeiculo = idVeiculo;
		this.titulo = titulo;
		this.descricao = descricao;
		this.dataCriacao = dataCriacao;
		this.base64Imagem = base64Imagem;
	}
	
	public AnuncioDTO(Anuncio anuncio) {
		super();
		this.setIdAnuncio(anuncio.getIdAnuncio());
		this.setIdUsuario(anuncio.getUsuario().getIdUsuario());
		this.setIdVeiculo(anuncio.getVeiculo().getIdVeiculo());
		this.setTitulo(anuncio.getTitulo());
		this.setDescricao(anuncio.getDescricao());
		this.setDataCriacao(anuncio.getDataCriacao());
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

	public Long getIdVeiculo() {
		return idVeiculo;
	}

	public void setIdVeiculo(Long idVeiculo) {
		this.idVeiculo = idVeiculo;
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

	public void setDescricao(String descricao) {
		this.descricao = descricao;
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
