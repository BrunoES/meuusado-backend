package com.meuusado.application.services;

import java.util.List;

import com.meuusado.application.domain.Veiculo;
import com.meuusado.application.ports.VeiculoRepositoryPort;
import com.meuusado.application.ports.VeiculoServicePort;

public class VeiculoServiceImpl implements VeiculoServicePort {

	private final VeiculoRepositoryPort veiculoRepository;
	
	public VeiculoServiceImpl(final VeiculoRepositoryPort veiculoRepository) {
		this.veiculoRepository = veiculoRepository;
	}
	
	@Override
	public List<Veiculo> findAll() {
		return veiculoRepository.findAll();
	}

	@Override
	public Veiculo findById(Long id) {
		return veiculoRepository.findById(id);
	}

	@Override
	public Veiculo save(Veiculo Veiculo) {
		return veiculoRepository.save(Veiculo);
	}

	@Override
	public Veiculo update(Veiculo Veiculo) {
		return veiculoRepository.save(Veiculo);
	}

	@Override
	public void delete(Veiculo Veiculo) {
		veiculoRepository.delete(Veiculo);
	}

	
}
