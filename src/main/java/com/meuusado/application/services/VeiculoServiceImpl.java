package com.meuusado.application.services;

import java.util.ArrayList;
import java.util.List;

import com.meuusado.application.domain.Veiculo;
import com.meuusado.application.domain.validation.ValidacaoPlaca;
import com.meuusado.application.domain.validation.impl.ValidacaoFormatoPlacaImpl;
import com.meuusado.application.ports.VeiculoRepositoryPort;
import com.meuusado.application.ports.VeiculoServicePort;

public class VeiculoServiceImpl implements VeiculoServicePort {

	private final VeiculoRepositoryPort veiculoRepository;

	private PlacaServiceImpl placaServiceImpl;

	public VeiculoServiceImpl(final VeiculoRepositoryPort veiculoRepository) {
		List<ValidacaoPlaca> list = new ArrayList<>();
		list.add(new ValidacaoFormatoPlacaImpl());
		list.add(new ValidacaoFormatoPlacaImpl());

		this.veiculoRepository = veiculoRepository;
		this.placaServiceImpl = new PlacaServiceImpl(list);
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
	public Veiculo save(Veiculo veiculo) {
		Veiculo novoVeiculo = null;
		try {
			this.valida(veiculo);
			novoVeiculo = veiculoRepository.save(veiculo);
		} catch(Exception e) {
			e.printStackTrace();
		}
		
		return novoVeiculo;
	}

	@Override
	public Veiculo update(Veiculo veiculo) {
		return veiculoRepository.save(veiculo);
	}

	@Override
	public void delete(Veiculo veiculo) {
		veiculoRepository.delete(veiculo);
	}

	@Override
	public Boolean valida(Veiculo veiculo) throws Exception {
		placaServiceImpl.valida(veiculo.placa());
		return true;
	}

	
}
