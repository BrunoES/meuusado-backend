package com.meuusado.meuusadovalidator.dto;

import java.io.Serializable;
import java.util.Date;
import java.util.List;

import org.bson.types.ObjectId;

public class AnuncioDTO implements Serializable {

	private static final long serialVersionUID = 1L;

	private ObjectId id;
	
	private Long idAnuncio;
	
	private Long idUsuario;
	
	private Long idModelo;
	
	private String nomeModelo;
	
	private String titulo;
	
	private String descricao;
	
	private int ano;
	
	private float valor;
	
	private Date dataCriacao;
	
	private String base64Imagem;
	
	private List<String> listAnuncioFotosBase64;

	public static long getSerialversionuid() {
		return serialVersionUID;
	}
	
	public AnuncioDTO() {
		super();
		// TODO Auto-generated constructor stub
	}

	public AnuncioDTO(ObjectId id, Long idAnuncio, Long idUsuario, Long idModelo, String nomeModelo, String titulo,
			String descricao, int ano, float valor, Date dataCriacao, String base64Imagem,
			List<String> listAnuncioFotosBase64) {
		super();
		this.id = id;
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
		this.listAnuncioFotosBase64 = listAnuncioFotosBase64;
	}

	public ObjectId getId() {
		return id;
	}

	public void setId(ObjectId id) {
		this.id = id;
	}

	public Long getIdAnuncio() {
		return idAnuncio;
	}

	public Long getIdUsuario() {
		return idUsuario;
	}

	public Long getIdModelo() {
		return idModelo;
	}

	public String getNomeModelo() {
		return nomeModelo;
	}

	public String getTitulo() {
		return titulo;
	}

	public String getDescricao() {
		return descricao;
	}

	public int getAno() {
		return ano;
	}

	public float getValor() {
		return valor;
	}

	public Date getDataCriacao() {
		return dataCriacao;
	}

	public String getBase64Imagem() {
		return base64Imagem;
	}

	public List<String> getListAnuncioFotosBase64() {
		return listAnuncioFotosBase64;
	}

	public void setIdAnuncio(Long idAnuncio) {
		this.idAnuncio = idAnuncio;
	}

	public void setIdUsuario(Long idUsuario) {
		this.idUsuario = idUsuario;
	}

	public void setIdModelo(Long idModelo) {
		this.idModelo = idModelo;
	}

	public void setNomeModelo(String nomeModelo) {
		this.nomeModelo = nomeModelo;
	}

	public void setTitulo(String titulo) {
		this.titulo = titulo;
	}

	public void setDescricao(String descricao) {
		this.descricao = descricao;
	}

	public void setAno(int ano) {
		this.ano = ano;
	}

	public void setValor(float valor) {
		this.valor = valor;
	}

	public void setDataCriacao(Date dataCriacao) {
		this.dataCriacao = dataCriacao;
	}

	public void setBase64Imagem(String base64Imagem) {
		this.base64Imagem = base64Imagem;
	}

	public void setListAnuncioFotosBase64(List<String> listAnuncioFotosBase64) {
		this.listAnuncioFotosBase64 = listAnuncioFotosBase64;
	}

	public AnuncioDTO criarId() {
		setId(new ObjectId());
		return this;
	}
	
}
