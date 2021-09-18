package com.meuusado.application.services;

import java.util.List;

import com.meuusado.application.domain.Anuncio;
import com.meuusado.application.ports.AnuncioRepositoryPort;
import com.meuusado.application.ports.AnuncioServicePort;

public class AnuncioServiceImpl implements AnuncioServicePort {

	private final AnuncioRepositoryPort anuncioRepository;
	
	public AnuncioServiceImpl(final AnuncioRepositoryPort anuncioRepository) {
		this.anuncioRepository = anuncioRepository;
	}
	
	@Override
	public List<Anuncio> findAll() {
		return anuncioRepository.findAll();
	}

	@Override
	public Anuncio findById(Long id) {
		return anuncioRepository.findById(id);
	}

	@Override
	public Anuncio save(Anuncio anuncio) {
		return anuncioRepository.save(anuncio);
	}

	@Override
	public Anuncio update(Anuncio anuncio) {
		return anuncioRepository.save(anuncio);
	}

	@Override
	public void delete(Anuncio anuncio) {
		anuncioRepository.delete(anuncio);
	}

	
}
