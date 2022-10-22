package com.meuusado.adapters.outbound.persistence;

import java.util.List;
import java.util.stream.Collectors;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Primary;
import org.springframework.stereotype.Component;

import com.meuusado.adapters.outbound.persistence.entity.AnuncioEntity;
import com.meuusado.adapters.outbound.persistence.entity.AnuncioFotosEntity;
import com.meuusado.application.domain.Anuncio;
import com.meuusado.application.domain.AnuncioFotos;
import com.meuusado.application.ports.AnuncioFotosRepositoryPort;

@Component
@Primary
public class PostgresAnuncioFotosRepository implements AnuncioFotosRepositoryPort {

	@Autowired
	private SpringDataPostgresAnuncioFotosRepository anuncioFotosRepository;
	
	@Autowired
    private ModelMapper modelMapper;
	
	@Override
	public List<AnuncioFotos> findAll() {
		return anuncioFotosRepository.findAll().stream().map(x -> x.toDomain()).collect(Collectors.toList());
	}

	@Override
	public AnuncioFotos findById(Long id) {
		AnuncioFotosEntity anuncioFotosEntity = anuncioFotosRepository.findById(id).orElse(null);
		return anuncioFotosEntity.toDomain();
	}

	@Override
	public List<AnuncioFotos> findByAnuncio(Anuncio anuncio) {
		AnuncioEntity anuncioEntity = modelMapper.map(anuncio, AnuncioEntity.class);
		List<AnuncioFotosEntity> listAnuncioFotosEntity = anuncioFotosRepository.findByIdAnuncio(anuncioEntity.getIdAnuncio());
		return listAnuncioFotosEntity.stream().map(x -> x.toDomain()).collect(Collectors.toList());
	}
	
	@Override
	public List<AnuncioFotos> findByAnuncio(Long idAnuncio) {
		List<AnuncioFotosEntity> listAnuncioFotosEntity = anuncioFotosRepository.findByIdAnuncio(idAnuncio);
		return listAnuncioFotosEntity.stream().map(x -> x.toDomain()).collect(Collectors.toList());
	}
	
	@Override
	public AnuncioFotos save(AnuncioFotos anuncioFoto) {
		AnuncioFotosEntity anuncioFotosEntity = modelMapper.map(anuncioFoto, AnuncioFotosEntity.class);
		anuncioFotosEntity.setBase64Img(anuncioFoto.base64Img());
		anuncioFotosEntity.setIdAnuncio(anuncioFoto.anuncio().idAnuncio());
		anuncioFotosEntity = anuncioFotosRepository.save(anuncioFotosEntity);
		return anuncioFotosEntity.toDomain();
	}

	@Override
	public void delete(AnuncioFotos anuncioFotos) {
		AnuncioFotosEntity anuncioFotosEntity = modelMapper.map(anuncioFotos, AnuncioFotosEntity.class);
		anuncioFotosRepository.delete(anuncioFotosEntity);
	}

}