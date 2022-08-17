package com.meuusado.meuusadovalidator.dto;

import java.io.Serializable;
import java.util.Date;
import java.util.List;

import com.fasterxml.jackson.annotation.JsonIgnore;

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
	
	private Date dataCriacao;
	
	private String base64Imagem;
	
	private List<String> listAnuncioFotosBase64;

	public static long getSerialversionuid() {
		return serialVersionUID;
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

}
