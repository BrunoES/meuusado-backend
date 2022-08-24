package com.meuusado.application.ports;

import java.util.List;

import com.meuusado.application.domain.Anuncio;

public interface AnuncioServicePort {
	
	List<Anuncio> findAll();
	
	Anuncio findById(Long id);
	
	List<Anuncio> findByQuery(String query);
	
	Anuncio save(Anuncio anuncio);
	
	Anuncio update(Anuncio anuncio);
	
	Anuncio aprove(Long idAnuncio);
	
	void delete(Anuncio anuncio);

	List<Anuncio> findBySituacaoAnuncio(int idSituacao);
	
}
