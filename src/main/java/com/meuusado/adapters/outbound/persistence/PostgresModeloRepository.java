package com.meuusado.adapters.outbound.persistence;

import java.util.List;
import java.util.stream.Collectors;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Primary;
import org.springframework.stereotype.Component;

import com.meuusado.adapters.outbound.persistence.entity.ModeloEntity;
import com.meuusado.application.domain.Marca;
import com.meuusado.application.domain.Modelo;
import com.meuusado.application.ports.ModeloRepositoryPort;

@Component
@Primary
public class PostgresModeloRepository implements ModeloRepositoryPort {

	@Autowired
	private SpringDataPostgresModeloRepository modeloRepository;
	
	@Autowired
    private ModelMapper modelMapper;
	
	@Override
	public List<Modelo> findAll() {
		return modeloRepository.findAll().stream().map(x -> modelMapper.map(x, Modelo.class)).collect(Collectors.toList());
	}

	@Override
	public Modelo findById(Long id) {
		ModeloEntity modeloEntity = modeloRepository.findById(id).orElse(null);
		return modelMapper.map(modeloEntity, Modelo.class);
	}

	@Override
	public Modelo save(Modelo modelo) {
		ModeloEntity modeloEntity = modelMapper.map(modelo, ModeloEntity.class);
		return modelMapper.map(modeloRepository.save(modeloEntity), Modelo.class);
	}

	@Override
	public void delete(Modelo modelo) {
		ModeloEntity modeloEntity = modelMapper.map(modelo, ModeloEntity.class);
		modeloRepository.delete(modeloEntity);
	}

	@Override
	public List<Modelo> findByMarca(Marca marca) {
		return modeloRepository.findByMarca(marca);
	}

}
