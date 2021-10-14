package com.meuusado.application.domain;

public class Placa {

	private String texto;
	
	private Cor cor;

	public Placa(String codigo){
		this.texto = codigo;
	}

	public String getTexto() {
		return texto;
	}

	public void setTexto(String texto) {
		this.texto = texto;
	}

	public Cor getCor() {
		return cor;
	}

	public void setCor(Cor cor) {
		this.cor = cor;
	}
	
}
