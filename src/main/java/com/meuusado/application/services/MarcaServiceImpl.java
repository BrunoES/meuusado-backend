package com.meuusado.application.services;

import java.util.List;

import com.meuusado.application.domain.Marca;
import com.meuusado.application.ports.MarcaRepositoryPort;
import com.meuusado.application.ports.MarcaServicePort;

public class MarcaServiceImpl implements MarcaServicePort {

	private final MarcaRepositoryPort marcaRepository;
	
	public MarcaServiceImpl(final MarcaRepositoryPort marcaRepository) {
		this.marcaRepository = marcaRepository;
	}
	
	@Override
	public List<Marca> findAll() {
		return marcaRepository.findAll();
	}

	@Override
	public Marca findById(Long id) {
		return marcaRepository.findById(id);
	}

	@Override
	public Marca save(Marca Marca) {
		return marcaRepository.save(Marca);
	}

	@Override
	public Marca update(Marca Marca) {
		return marcaRepository.save(Marca);
	}

	@Override
	public void delete(Marca Marca) {
		marcaRepository.delete(Marca);
	}

	
}
