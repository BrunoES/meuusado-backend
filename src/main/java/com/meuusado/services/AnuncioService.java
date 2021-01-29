package com.meuusado.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.meuusado.business.AnuncioBusiness;
import com.meuusado.dtos.AnuncioDTO;
import com.meuusado.entities.Anuncio;

@Service
public class AnuncioService {

	@Autowired
	private AnuncioBusiness anuncioBusiness;
	
	public List<Anuncio> findAll() {
		return anuncioBusiness.findAll();
	}
	
	public Anuncio findById(Long id) {
		return anuncioBusiness.findById(id);
	}
	
	public Anuncio save(AnuncioDTO anuncioDto) {
		return anuncioBusiness.save(anuncioDto);
	}
	
	public Anuncio update(AnuncioDTO anuncioDto) {
		return anuncioBusiness.save(anuncioDto);
	}
	
	public void delete(Long id) {
		anuncioBusiness.delete(id);
	}
	
}
