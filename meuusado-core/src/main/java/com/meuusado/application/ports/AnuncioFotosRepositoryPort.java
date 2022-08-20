package com.meuusado.application.ports;

import java.util.List;

import com.meuusado.application.domain.Anuncio;
import com.meuusado.application.domain.AnuncioFotos;

public interface AnuncioFotosRepositoryPort {

	List<AnuncioFotos> findAll();
	
	AnuncioFotos findById(Long id);
	
	List<AnuncioFotos> findByAnuncio(Anuncio anuncio);
	
	List<AnuncioFotos> findByAnuncio(Long idAnuncio);
	
	AnuncioFotos save(AnuncioFotos anuncioFotos);
	
	void delete(AnuncioFotos anuncioFotos);
	
}