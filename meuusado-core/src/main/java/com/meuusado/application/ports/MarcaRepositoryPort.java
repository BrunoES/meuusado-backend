package com.meuusado.application.ports;

import java.util.List;

import com.meuusado.application.domain.Marca;

public interface MarcaRepositoryPort {

	List<Marca> findAll();
	
	Marca findById(Long id);
	
	Marca save(Marca marca);
	
	void delete(Marca marca);
	
}
