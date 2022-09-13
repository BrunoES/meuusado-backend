package com.meuusado.application.services;

import java.util.ArrayList;
import java.util.List;
import java.util.UUID;
import java.util.concurrent.ExecutionException;

import com.meuusado.application.domain.Anuncio;
import com.meuusado.application.domain.enums.SituacaoAnuncio;
import com.meuusado.application.ports.AnuncioRepositoryPort;
import com.meuusado.application.ports.AnuncioServicePort;
import com.meuusado.application.ports.MessagingServicePort;

public class AnuncioServiceImpl implements AnuncioServicePort {

	private final AnuncioRepositoryPort anuncioRepository;
	
	private MessagingServicePort<Anuncio> messagingService;
	
	public AnuncioServiceImpl(final AnuncioRepositoryPort anuncioRepository, MessagingServicePort<Anuncio> messagingService) {
		this.anuncioRepository = anuncioRepository;
		this.messagingService = messagingService;
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
	
	private void submitMongoDBDatabaseQueue(Anuncio anuncio) {
		String key = UUID.randomUUID().toString();
		try {
			messagingService.send("MEUUSADO.ANNOUNCEMENT-VALIDATION", key, anuncio);
		} catch (InterruptedException | ExecutionException e) {
			e.printStackTrace();
		}
	}

	@Override
	public Anuncio aprove(Long idAnuncio) {
		Anuncio anuncio = anuncioRepository.findById(idAnuncio);
		Anuncio anuncioAprovado = new Anuncio(anuncio.idAnuncio(), anuncio.usuario(), anuncio.modelo(), anuncio.titulo(), anuncio.descricao(), anuncio.ano(), anuncio.valor(), anuncio.dataCriacao(), anuncio.base64ImgPrincMin(), anuncio.pathImagem(), anuncio.listAnuncioFotos(), SituacaoAnuncio.APROVADO);
		anuncioAprovado = anuncioRepository.save(anuncioAprovado);
		submitMongoDBDatabaseQueue(anuncio);
		return anuncioAprovado;
	}

	@Override
	public List<Anuncio> findBySituacaoAnuncio(int idSituacao) {
		return anuncioRepository.findBySituacaoAnuncio(idSituacao);
	}

	
}