package com.meuusado.application.ports;

import java.util.List;

import com.meuusado.application.domain.Veiculo;

public interface VeiculoServicePort {
	
	List<Veiculo> findAll();
	
	Veiculo findById(Long id);
	
	Veiculo save(Veiculo veiculo);
	
	Veiculo update(Veiculo veiculo);
	
	void delete(Veiculo veiculo);
	
	Boolean valida(Veiculo veiculo) throws Exception;
	
}
