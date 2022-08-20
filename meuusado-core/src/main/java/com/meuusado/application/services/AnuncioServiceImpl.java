package com.meuusado.application.services;

import java.util.ArrayList;
import java.util.List;
import java.util.UUID;
import java.util.concurrent.ExecutionException;

import com.meuusado.adapters.outbound.messaging.KafkaDispatcher;
import com.meuusado.application.domain.Anuncio;
import com.meuusado.application.ports.AnuncioRepositoryPort;
import com.meuusado.application.ports.AnuncioServicePort;

public class AnuncioServiceImpl implements AnuncioServicePort {

	private static KafkaDispatcher<Anuncio> anuncioDispatcher = new KafkaDispatcher<>();
	
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
		Anuncio anuncio = anuncioRepository.findById(id);
		return anuncio;
	}

	@Override
	public Anuncio save(Anuncio anuncio) {
		Anuncio anuncioReturn = anuncioRepository.save(anuncio);
		//submitValidation(anuncio);
		return anuncioReturn;
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
			
			if(anuncio.modelo() != null) {
				modelo = anuncio.modelo().nome();
				marca = anuncio.modelo().marca().nome();	
			}
			
			String objectIdentity = String.valueOf(anuncio.ano()).concat(" ")
					.concat(anuncio.descricao()).concat(" ")
						.concat(anuncio.titulo()).concat(" ")
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
	
	private void submitValidation(Anuncio anuncio) {
		String key = UUID.randomUUID().toString();
		try {
			anuncioDispatcher.send("MEUUSADO.ANNOUNCEMENT-VALIDATION", key, anuncio);
		} catch (InterruptedException | ExecutionException e) {
			e.printStackTrace();
		}
	}

	
}
