package com.meuusado.application.ports;

import java.util.List;

import com.meuusado.application.domain.Veiculo;

public interface VeiculoRepositoryPort {

	List<Veiculo> findAll();
	
	Veiculo findById(Long id);
	
	Veiculo save(Veiculo veiculo);
	
	void delete(Veiculo veiculo);
	
}
