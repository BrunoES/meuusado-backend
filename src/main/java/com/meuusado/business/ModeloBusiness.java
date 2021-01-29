package com.meuusado.business;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.meuusado.dtos.ModeloDTO;
import com.meuusado.entities.Modelo;
import com.meuusado.repository.MarcaRepository;
import com.meuusado.repository.ModeloRepository;

@Component
public class ModeloBusiness {

	@Autowired
	private MarcaRepository marcaRepository;
	
	@Autowired
	private ModeloRepository modeloRepository;
	
	public List<Modelo> findAll() {
		return modeloRepository.findAll();
	}
	
	public Modelo findById(Long id) {
		return modeloRepository.findById(id).orElse(null);
	}
	
	public Modelo save(ModeloDTO modeloDto) {
		Modelo modelo = dtoToEntity(modeloDto);
		return modeloRepository.save(modelo);
	}
	
	public void delete(Long id) {
		modeloRepository.findById(id).ifPresent(modelo -> {
			modeloRepository.delete(modelo);
		});
	}
	
	public Modelo dtoToEntity(ModeloDTO modeloDto) {
		Modelo modelo = new Modelo();
		modelo.setIdModelo(modeloDto.getIdModelo());
		modelo.setName(modeloDto.getNomeModelo());
		modelo.setMarca(marcaRepository.findById(modeloDto.getIdModelo()).orElse(null));
		return modelo;
	}
}
