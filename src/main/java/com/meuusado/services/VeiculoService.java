package com.meuusado.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.meuusado.business.VeiculoBusiness;
import com.meuusado.dtos.VeiculoDTO;
import com.meuusado.entities.Veiculo;

@Service
public class VeiculoService {

	@Autowired
	private VeiculoBusiness veiculoBusiness;
	
	public List<Veiculo> findAll() {
		return veiculoBusiness.findAll();
	}
	
	public Veiculo findById(Long id) {
		return veiculoBusiness.findById(id);
	}
	
	public Veiculo save(VeiculoDTO veiculoDto) {
		return veiculoBusiness.save(veiculoDto);
	}
	
	public Veiculo update(VeiculoDTO veiculoDto) {
		return veiculoBusiness.save(veiculoDto);
	}
	
	public void delete(Long id) {
		veiculoBusiness.delete(id);
	}
	
}
