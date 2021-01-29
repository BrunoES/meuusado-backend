package com.meuusado.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.meuusado.business.ModeloBusiness;
import com.meuusado.dtos.ModeloDTO;
import com.meuusado.entities.Modelo;

@Service
public class ModeloService {

	@Autowired
	private ModeloBusiness modeloBusiness;
	
	public List<Modelo> findAll() {
		return modeloBusiness.findAll();
	}
	
	public Modelo findById(Long id) {
		return modeloBusiness.findById(id);
	}
	
	public Modelo save(ModeloDTO modeloDto) {
		return modeloBusiness.save(modeloDto);
	}
	
	public Modelo update(ModeloDTO modeloDto) {
		return modeloBusiness.save(modeloDto);
	}
	
	public void delete(Long id) {
		modeloBusiness.delete(id);
	}
	
}
