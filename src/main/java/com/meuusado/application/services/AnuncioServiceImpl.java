package com.meuusado.application.services;

import java.util.ArrayList;
import java.util.List;

import com.meuusado.application.domain.Anuncio;
import com.meuusado.application.domain.AnuncioFotos;
import com.meuusado.application.ports.AnuncioFotosRepositoryPort;
import com.meuusado.application.ports.AnuncioRepositoryPort;
import com.meuusado.application.ports.AnuncioServicePort;

public class AnuncioServiceImpl implements AnuncioServicePort {

	private final AnuncioRepositoryPort anuncioRepository;
	
	private final AnuncioFotosRepositoryPort anuncioFotosRepositoryPort;
	
	public AnuncioServiceImpl(final AnuncioRepositoryPort anuncioRepository, AnuncioFotosRepositoryPort anuncioFotosRepositoryPort) {
		this.anuncioRepository = anuncioRepository;
		this.anuncioFotosRepositoryPort = anuncioFotosRepositoryPort;
	}
	
	@Override
	public List<Anuncio> findAll() {
		return anuncioRepository.findAll();
	}

	@Override
	public Anuncio findById(Long id) {
		Anuncio anuncio = anuncioRepository.findById(id);
		List<AnuncioFotos> listAnuncioFotos = anuncioFotosRepositoryPort.findByAnuncio(anuncio);
		anuncio.setListAnuncioFotos(listAnuncioFotos);
		return anuncio;
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

	@Override
	public List<Anuncio> findByQuery(String query) {
		List<Anuncio> list = anuncioRepository.findAll();
		List<Anuncio> resultList = new ArrayList<Anuncio>();
		String[] queries = query.split(" ");
		
		list.forEach(anuncio -> {
			String modelo = "";
			String marca = "";
			
			if(anuncio.getModelo() != null) {
				modelo = anuncio.getModelo().getName();
				marca = anuncio.getModelo().getMarca().getNome();	
			}
			
			String objectIdentity = String.valueOf(anuncio.getAno()).concat(" ")
					.concat(anuncio.getDescricao()).concat(" ")
						.concat(anuncio.getTitulo()).concat(" ")
							.concat(modelo).concat(" ")
								.concat(marca);
			objectIdentity = objectIdentity.toLowerCase();
			
			for(int i = 0; i < queries.length; i ++) {
				if(objectIdentity.contains(queries[i])) {
					resultList.add(anuncio);
					break;
				}
			}
		});
		
		return resultList;
	}

	
}
