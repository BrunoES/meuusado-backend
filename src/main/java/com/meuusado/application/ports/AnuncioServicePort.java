package com.meuusado.application.ports;

import java.util.List;

import com.meuusado.application.domain.Anuncio;

public interface AnuncioServicePort {
	
	List<Anuncio> findAll();
	
	Anuncio findById(Long id);
	
	Anuncio save(Anuncio anuncio);
	
	Anuncio update(Anuncio anuncio);
	
	void delete(Anuncio anuncio);
	
}
