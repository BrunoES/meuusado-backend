package com.meuusado.application.services;

import java.util.List;

import com.meuusado.application.domain.Marca;
import com.meuusado.application.domain.Modelo;
import com.meuusado.application.ports.ModeloRepositoryPort;
import com.meuusado.application.ports.ModeloServicePort;

public class ModeloServiceImpl implements ModeloServicePort {

	private final ModeloRepositoryPort modeloRepository;
	
	public ModeloServiceImpl(final ModeloRepositoryPort modeloRepository) {
		this.modeloRepository = modeloRepository;
	}
	
	@Override
	public List<Modelo> findAll() {
		return modeloRepository.findAll();
	}

	@Override
	public Modelo findById(Long id) {
		return modeloRepository.findById(id);
	}

	@Override
	public Modelo save(Modelo Modelo) {
		return modeloRepository.save(Modelo);
	}

	@Override
	public Modelo update(Modelo Modelo) {
		return modeloRepository.save(Modelo);
	}

	@Override
	public void delete(Modelo Modelo) {
		modeloRepository.delete(Modelo);
	}

	@Override
	public List<Modelo> findByMarca(Marca marca) {
		return modeloRepository.findByMarca(marca);
	}

	
}
