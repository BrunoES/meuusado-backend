package com.meuusado.application.services;

import java.util.List;

import com.meuusado.application.domain.Veiculo;
import com.meuusado.application.ports.VeiculoRepositoryPort;
import com.meuusado.application.ports.VeiculoServicePort;

public class VeiculoServiceImpl implements VeiculoServicePort {

	private final VeiculoRepositoryPort VeiculoRepository;
	
	public VeiculoServiceImpl(final VeiculoRepositoryPort VeiculoRepository) {
		this.VeiculoRepository = VeiculoRepository;
	}
	
	@Override
	public List<Veiculo> findAll() {
		return VeiculoRepository.findAll();
	}

	@Override
	public Veiculo findById(Long id) {
		return VeiculoRepository.findById(id);
	}

	@Override
	public Veiculo save(Veiculo Veiculo) {
		return VeiculoRepository.save(Veiculo);
	}

	@Override
	public Veiculo update(Veiculo Veiculo) {
		return VeiculoRepository.save(Veiculo);
	}

	@Override
	public void delete(Veiculo Veiculo) {
		VeiculoRepository.delete(Veiculo);
	}

	
}
