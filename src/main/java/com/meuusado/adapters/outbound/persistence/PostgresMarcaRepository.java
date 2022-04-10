package com.meuusado.adapters.outbound.persistence;

import java.util.List;
import java.util.stream.Collectors;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Primary;
import org.springframework.stereotype.Component;

import com.meuusado.adapters.outbound.persistence.entity.MarcaEntity;
import com.meuusado.application.domain.Marca;
import com.meuusado.application.ports.MarcaRepositoryPort;

@Component
@Primary
public class PostgresMarcaRepository implements MarcaRepositoryPort {

	@Autowired
	private SpringDataPostgresMarcaRepository marcaRepository;
	
	@Autowired
    private ModelMapper modelMapper;
	
	@Override
	public List<Marca> findAll() {
		List<MarcaEntity> list = marcaRepository.findAll();
		return list.stream().map(x -> modelMapper.map(x, Marca.class)).collect(Collectors.toList());
	}

	@Override
	public Marca findById(Long id) {
		MarcaEntity MarcaEntity = marcaRepository.findById(id).orElse(null);
		return modelMapper.map(MarcaEntity, Marca.class);
	}

	@Override
	public Marca save(Marca marca) {
		MarcaEntity MarcaEntity = modelMapper.map(marca, MarcaEntity.class);
		return modelMapper.map(marcaRepository.save(MarcaEntity), Marca.class);
	}

	@Override
	public void delete(Marca marca) {
		MarcaEntity MarcaEntity = modelMapper.map(marca, MarcaEntity.class);
		marcaRepository.delete(MarcaEntity);
	}

}
