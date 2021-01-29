package com.meuusado.business;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.meuusado.dtos.MarcaDTO;
import com.meuusado.entities.Marca;
import com.meuusado.repository.MarcaRepository;

@Component
public class MarcaBusiness {

	@Autowired
	private MarcaRepository marcaRepository;
	
	public List<Marca> findAll() {
		return marcaRepository.findAll();
	}
	
	public Marca findById(Long id) {
		return marcaRepository.findById(id).orElse(null);
	}
	
	public Marca save(MarcaDTO marcaDto) {
		Marca marca = dtoToEntity(marcaDto);
		return marcaRepository.save(marca);
	}
	
	public void delete(Long id) {
		marcaRepository.findById(id).ifPresent(marca -> {
			marcaRepository.delete(marca);
		});
	}
	
	public Marca dtoToEntity(MarcaDTO marcaDto) {
		Marca marca = new Marca();
		marca.setIdMarca(marcaDto.getIdMarca());
		marca.setName(marcaDto.getName());
		return marca;
	}
}
