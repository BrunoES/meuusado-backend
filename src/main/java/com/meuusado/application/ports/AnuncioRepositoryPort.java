package com.meuusado.application.ports;

import java.util.List;

import com.meuusado.application.domain.Anuncio;

public interface AnuncioRepositoryPort {

	List<Anuncio> findAll();
	
	Anuncio findById(Long id);
	
	Anuncio save(Anuncio anuncio);
	
	void delete(Anuncio anuncio);
	
}
