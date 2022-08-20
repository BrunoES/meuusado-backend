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
		return list.stream().map(x -> x.toDomain()).collect(Collectors.toList());
	}

	@Override
	public Marca findById(Long id) {
		MarcaEntity marcaEntity = marcaRepository.findById(id).orElse(null);
		return marcaEntity.toDomain();
	}

	@Override
	public Marca save(Marca marca) {
		MarcaEntity marcaEntity = new MarcaEntity();
		marcaEntity.setNome(marca.nome());
		marcaEntity = marcaRepository.save(marcaEntity);
		return marcaEntity.toDomain();
	}

	@Override
	public void delete(Marca marca) {
		MarcaEntity MarcaEntity = modelMapper.map(marca, MarcaEntity.class);
		marcaRepository.delete(MarcaEntity);
	}

}
