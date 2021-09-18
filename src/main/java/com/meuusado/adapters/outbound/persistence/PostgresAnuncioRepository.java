package com.meuusado.adapters.outbound.persistence;

import java.util.List;
import java.util.stream.Collectors;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Primary;
import org.springframework.stereotype.Component;

import com.meuusado.adapters.outbound.persistence.entity.AnuncioEntity;
import com.meuusado.application.domain.Anuncio;
import com.meuusado.application.ports.AnuncioRepositoryPort;

@Component
@Primary
public class PostgresAnuncioRepository implements AnuncioRepositoryPort {

	@Autowired
	private SpringDataPostgresAnuncioRepository anuncioRepository;
	
	@Autowired
    private ModelMapper modelMapper;
	
	@Override
	public List<Anuncio> findAll() {
		return anuncioRepository.findAll().stream().map(x -> modelMapper.map(x, Anuncio.class)).collect(Collectors.toList());
	}

	@Override
	public Anuncio findById(Long id) {
		AnuncioEntity anuncioEntity = anuncioRepository.findById(id).orElse(null);
		return modelMapper.map(anuncioEntity, Anuncio.class);
	}

	@Override
	public Anuncio save(Anuncio anuncio) {
		AnuncioEntity anuncioEntity = modelMapper.map(anuncio, AnuncioEntity.class);
		return modelMapper.map(anuncioRepository.save(anuncioEntity), Anuncio.class);
	}

	@Override
	public void delete(Anuncio anuncio) {
		AnuncioEntity anuncioEntity = modelMapper.map(anuncio, AnuncioEntity.class);
		anuncioRepository.delete(anuncioEntity);
	}

}
