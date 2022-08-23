package com.meuusado.application.domain.enums;

import com.fasterxml.jackson.annotation.JsonValue;

public enum SituacaoAnuncio {
	AGUARDANDO_APROVACAO(1),
	APROVADO(2),
	REPROVADO(3);
	
	public int situacaoAnuncio;
	
	SituacaoAnuncio(int situacao) {
		situacaoAnuncio = situacao;
	}
	
	public static SituacaoAnuncio valueOf(int situacao) {
		for (SituacaoAnuncio l : SituacaoAnuncio.values()) {
	          if (l.situacaoAnuncio == situacao) return l;
	      }
		return null;
	}
	
	@JsonValue
    final int value() {
        return this.situacaoAnuncio;
    }
	
}