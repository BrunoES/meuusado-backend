package com.meuusado.application.services;

import java.util.ArrayList;
import java.util.List;
import java.util.UUID;
import java.util.concurrent.ExecutionException;

import com.meuusado.adapters.outbound.messaging.KafkaDispatcher;
import com.meuusado.application.domain.Anuncio;
import com.meuusado.application.domain.AnuncioFotos;
import com.meuusado.application.ports.AnuncioFotosRepositoryPort;
import com.meuusado.application.ports.AnuncioRepositoryPort;
import com.meuusado.application.ports.AnuncioServicePort;

public class AnuncioServiceImpl implements AnuncioServicePort {

	private static KafkaDispatcher<Anuncio> anuncioDispatcher = new KafkaDispatcher<>();
	
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
		//anuncio.setListAnuncioFotos(listAnuncioFotos);
		return anuncio;
	}

	@Override
	public Anuncio save(Anuncio anuncio) {
		Anuncio anuncioReturn = anuncioRepository.save(anuncio);
		List<AnuncioFotos> listAnuncioFotos = new ArrayList<AnuncioFotos>();
		
		anuncio.listAnuncioFotos().forEach(x -> {
			AnuncioFotos anuncioFotos = new AnuncioFotos(x.idFoto(), anuncioReturn, x.base64Img());
			listAnuncioFotos.add(anuncioFotosRepositoryPort.save(anuncioFotos));
		});

		submitValidation(anuncioReturn);
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
