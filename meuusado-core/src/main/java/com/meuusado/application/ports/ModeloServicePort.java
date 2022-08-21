package com.meuusado.application.ports;

import java.util.List;

import com.meuusado.application.domain.Modelo;

public interface ModeloServicePort {
	
	List<Modelo> findAll();
	
	Modelo findById(Long id);
	
	Modelo save(Modelo modelo);
	
	Modelo update(Modelo modelo);
	
	void delete(Modelo modelo);

	List<Modelo> findByIdMarca(Long idMarca);
	
}
