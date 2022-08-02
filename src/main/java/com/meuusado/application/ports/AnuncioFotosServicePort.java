package com.meuusado.application.ports;

import java.util.List;

import com.meuusado.application.domain.AnuncioOld;
import com.meuusado.application.domain.AnuncioFotos;

public interface AnuncioFotosServicePort {
	
	List<AnuncioFotos> findAll();
	
	AnuncioFotos findById(Long id);
	
	List<AnuncioFotos> findByAnuncio(AnuncioOld anuncio);
	
	AnuncioFotos save(AnuncioFotos anuncioFotos);
	
	AnuncioFotos update(AnuncioFotos anuncioFotos);
	
	void delete(AnuncioFotos anuncioFotos);
	
	Boolean valida(AnuncioFotos anuncioFotos) throws Exception;
	
}