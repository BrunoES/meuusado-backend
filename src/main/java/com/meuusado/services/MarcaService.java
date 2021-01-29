package com.meuusado.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.meuusado.business.MarcaBusiness;
import com.meuusado.dtos.MarcaDTO;
import com.meuusado.entities.Marca;

@Service
public class MarcaService {

	@Autowired
	private MarcaBusiness marcaBusiness;
	
	public List<Marca> findAll() {
		return marcaBusiness.findAll();
	}
	
	public Marca findById(Long id) {
		return marcaBusiness.findById(id);
	}
	
	public Marca save(MarcaDTO marcaDto) {
		return marcaBusiness.save(marcaDto);
	}
	
	public Marca update(MarcaDTO marcaDto) {
		return marcaBusiness.save(marcaDto);
	}
	
	public void delete(Long id) {
		marcaBusiness.delete(id);
	}
	
}
