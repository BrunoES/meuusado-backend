package com.meuusado.meuusadosearcher.dto;

import java.io.Serializable;
import java.util.Date;
import java.util.List;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.meuusado.meuusadosearcher.domain.Anuncio;
import com.meuusado.meuusadosearcher.domain.AnuncioFotos;

public class AnuncioDTO implements Serializable {

	private static final long serialVersionUID = 1L;

	private Long idAnuncio;
	
	private Long idUsuario;
	
	private Long idModelo;
	
	private String nomeModelo;
	
	private String titulo;
	
	private String descricao;
	
	private int ano;
	
	private float valor;
	
	//@NotNull
	//@JsonFormat(pattern = "dd/MM/yyyy")
	private Date dataCriacao;
	
	private String base64Imagem;
	
	private List<String> listAnuncioFotosBase64;
	
	@JsonIgnore
	private List<AnuncioFotos> listAnuncioFotos;
	
	public AnuncioDTO() {
		super();
		// TODO Auto-generated constructor stub
	}

	public AnuncioDTO(Long idUsuario, Long idModelo, String titulo, String descricao, int ano, float valor, Date dataCriacao,
			String base64Imagem) {
		super();
		this.idUsuario = idUsuario;
		this.idModelo = idModelo;
		this.titulo = titulo;
		this.descricao = descricao;
		this.ano = ano;
		this.valor = valor;
		this.dataCriacao = dataCriacao;
		this.base64Imagem = base64Imagem;
	}
	
	public AnuncioDTO(Long idUsuario, Long idModelo, String nomeModelo, String titulo, String descricao, int ano, float valor, Date dataCriacao,
			String base64Imagem) {
		super();
		this.idUsuario = idUsuario;
		this.idModelo = idModelo;
		this.nomeModelo = nomeModelo;
		this.titulo = titulo;
		this.descricao = descricao;
		this.ano = ano;
		this.valor = valor;
		this.dataCriacao = dataCriacao;
		this.base64Imagem = base64Imagem;
	}
	
	public AnuncioDTO(Long idAnuncio, Long idUsuario, Long idModelo, String nomeModelo, String titulo, String descricao, int ano, float valor, Date dataCriacao,
			String base64Imagem) {
		super();
		this.idAnuncio = idAnuncio;
		this.idUsuario = idUsuario;
		this.idModelo = idModelo;
		this.nomeModelo = nomeModelo;
		this.titulo = titulo;
		this.descricao = descricao;
		this.ano = ano;
		this.valor = valor;
		this.dataCriacao = dataCriacao;
		this.base64Imagem = base64Imagem;
	}
	
	public AnuncioDTO(Anuncio anuncio) {
		super();
		this.setIdAnuncio(anuncio.idAnuncio());
		this.setIdUsuario(anuncio.usuario() != null ? anuncio.usuario().idUsuario() : null);
		this.setIdModelo(anuncio.modelo() != null ? anuncio.modelo().idModelo() : null);
		this.setNomeModelo(anuncio.modelo() != null ? anuncio.modelo().nome() : "");
		this.setTitulo(anuncio.titulo());
		this.setDescricao(anuncio.descricao());
		this.setAno(anuncio.ano());
		this.setValor(anuncio.valor());
		this.setDataCriacao(anuncio.dataCriacao());
		this.setBase64Imagem(anuncio.base64ImgPrincMin());
		this.setListAnuncioFotos(anuncio.listAnuncioFotos());
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

	public List<AnuncioFotos> getListAnuncioFotos() {
		return listAnuncioFotos;
	}

	public void setListAnuncioFotos(List<AnuncioFotos> listAnuncioFotos) {
		this.listAnuncioFotos = listAnuncioFotos;
	}
	
	public List<String> getListAnuncioFotosBase64() {
		return listAnuncioFotosBase64;
	}

	public void setListAnuncioFotosBase64(List<String> listAnuncioFotosBase64) {
		this.listAnuncioFotosBase64 = listAnuncioFotosBase64;
	}

	public int getAno() {
		return ano;
	}

	public void setAno(int ano) {
		this.ano = ano;
	}

}
