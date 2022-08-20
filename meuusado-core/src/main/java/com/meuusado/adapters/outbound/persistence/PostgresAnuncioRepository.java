package com.meuusado.adapters.outbound.persistence;

import java.util.ArrayList;
import java.util.List;

import javax.transaction.Transactional;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Primary;
import org.springframework.stereotype.Component;

import com.meuusado.adapters.outbound.persistence.entity.AnuncioEntity;
import com.meuusado.adapters.outbound.persistence.entity.AnuncioFotosEntity;
import com.meuusado.application.domain.Anuncio;
import com.meuusado.application.ports.AnuncioRepositoryPort;

@Component
@Primary
public class PostgresAnuncioRepository implements AnuncioRepositoryPort {

	@Autowired
	private SpringDataPostgresAnuncioRepository anuncioRepository;
	
	@Autowired
	private SpringDataPostgresAnuncioFotosRepository anuncioFotosRepository;
	
	@Autowired
    private ModelMapper modelMapper;
	
	@Override
	public List<Anuncio> findAll() {
		List<Anuncio> listAnunciosDomain = new ArrayList<Anuncio>();
		
		anuncioRepository.findAll().forEach(anuncioEntity -> {
			anuncioEntity = fillAnuncio(anuncioEntity);
			listAnunciosDomain.add(anuncioEntity.toDomain());
		});
		
		return listAnunciosDomain;
	}

	@Override
	public Anuncio findById(Long id) {
		AnuncioEntity anuncioEntity = anuncioRepository.findById(id).orElse(null);
		anuncioEntity = fillAnuncio(anuncioEntity);
		return anuncioEntity.toDomain();
	}

	@Override
	public Anuncio save(Anuncio anuncio) {
		AnuncioEntity anuncioEntity = new AnuncioEntity();
		
		anuncioEntity.setTitulo(anuncio.titulo());
		anuncioEntity.setDescricao(anuncio.descricao());
		anuncioEntity.setValor(anuncio.valor());
		anuncioEntity.setAno(anuncio.ano());
		anuncioEntity.setBase64ImgPrincMin(anuncio.base64ImgPrincMin());
		
		anuncioEntity = anuncioRepository.save(anuncioEntity);
		
		final Long idAnuncio = anuncioEntity.getIdAnuncio();
		
		anuncio.listAnuncioFotos().stream().forEach(x -> {
			anuncioFotosRepository.save(new AnuncioFotosEntity(null, idAnuncio, x.base64Img()));
		});
		
		anuncioEntity = fillAnuncio(anuncioEntity);
		return anuncioEntity.toDomain();
	}

	@Override
	public void delete(Anuncio anuncio) {
		AnuncioEntity anuncioEntity = modelMapper.map(anuncio, AnuncioEntity.class);
		anuncioRepository.delete(anuncioEntity);
	}
	
	@Transactional
	private AnuncioEntity fillAnuncio(AnuncioEntity anuncioEntity) {
		List<AnuncioFotosEntity> listFotosAnuncioEntity = anuncioFotosRepository.findByIdAnuncio(anuncioEntity.getIdAnuncio());
		anuncioEntity.setListAnuncioFotos(listFotosAnuncioEntity);
		return anuncioEntity;
	}

}
