package com.meuusado.adapters.outbound.persistence.entity;

import java.util.Objects;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

import com.meuusado.application.domain.AnuncioFotos;

@Entity
@Table(name = "MU_ANUNCIO_FOTOS")
public class AnuncioFotosEntity {
	
	@Id
	@GeneratedValue
	@Column(name="ID_FOTO")
	private Long idFoto;
	
	@ManyToOne
	@JoinColumn(name="ID_ANUNCIO")
	private AnuncioEntity anuncio;
	
	@Column(name="BASE64_IMG")
	private String base64Img;

	public Long getIdFoto() {
		return idFoto;
	}

	public void setIdFoto(Long idFoto) {
		this.idFoto = idFoto;
	}

	public AnuncioEntity getAnuncio() {
		return anuncio;
	}

	public void setAnuncio(AnuncioEntity anuncio) {
		this.anuncio = anuncio;
	}

	public String getBase64Img() {
		return base64Img;
	}

	public void setBase64Img(String base64Img) {
		this.base64Img = base64Img;
	}
	
	public AnuncioFotos toDomain() {
		return new AnuncioFotos(this.idFoto,
				Objects.isNull(this.anuncio) ? null : this.anuncio.toDomain(),
				this.base64Img);
	}

}
