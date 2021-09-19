package com.meuusado.application.services;

import java.util.List;

import com.meuusado.application.domain.Marca;
import com.meuusado.application.ports.MarcaRepositoryPort;
import com.meuusado.application.ports.MarcaServicePort;

public class MarcaServiceImpl implements MarcaServicePort {

	private final MarcaRepositoryPort MarcaRepository;
	
	public MarcaServiceImpl(final MarcaRepositoryPort MarcaRepository) {
		this.MarcaRepository = MarcaRepository;
	}
	
	@Override
	public List<Marca> findAll() {
		return MarcaRepository.findAll();
	}

	@Override
	public Marca findById(Long id) {
		return MarcaRepository.findById(id);
	}

	@Override
	public Marca save(Marca Marca) {
		return MarcaRepository.save(Marca);
	}

	@Override
	public Marca update(Marca Marca) {
		return MarcaRepository.save(Marca);
	}

	@Override
	public void delete(Marca Marca) {
		MarcaRepository.delete(Marca);
	}

	
}
