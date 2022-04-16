package com.meuusado.application.domain;

public class AnuncioFotos {

	private Long idFoto;
	
	private Anuncio anuncio;
	
	private String base64Img;

	public AnuncioFotos() {
		super();
	}

	public AnuncioFotos(Long idFoto, Anuncio anuncio, String base64Img) {
		super();
		this.idFoto = idFoto;
		this.anuncio = anuncio;
		this.base64Img = base64Img;
	}

	public Long getIdFoto() {
		return idFoto;
	}

	public void setIdFoto(Long idFoto) {
		this.idFoto = idFoto;
	}

	public Anuncio getAnuncio() {
		return anuncio;
	}

	public void setAnuncio(Anuncio anuncio) {
		this.anuncio = anuncio;
	}

	public String getBase64Img() {
		return base64Img;
	}

	public void setBase64Img(String base64Img) {
		this.base64Img = base64Img;
	}
	
}
