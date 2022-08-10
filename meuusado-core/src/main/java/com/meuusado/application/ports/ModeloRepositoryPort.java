package com.meuusado.application.ports;

import java.util.List;

import com.meuusado.application.domain.Marca;
import com.meuusado.application.domain.Modelo;

public interface ModeloRepositoryPort {

	List<Modelo> findAll();
	
	Modelo findById(Long id);
	
	Modelo save(Modelo modelo);
	
	void delete(Modelo modelo);

	List<Modelo> findByMarca(Marca marca);
	
}
