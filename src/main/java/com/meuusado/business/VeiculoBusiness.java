package com.meuusado.business;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.meuusado.dtos.VeiculoDTO;
import com.meuusado.entities.Modelo;
import com.meuusado.entities.Usuario;
import com.meuusado.entities.Veiculo;
import com.meuusado.repository.ModeloRepository;
import com.meuusado.repository.UsuarioRepository;
import com.meuusado.repository.VeiculoRepository;

@Component
public class VeiculoBusiness {

	@Autowired
	private VeiculoRepository veiculoRepository;
	
	@Autowired
	private UsuarioRepository usuarioRepository;
	
	@Autowired
	private ModeloRepository modeloRepository;
	
	public List<Veiculo> findAll() {
		return veiculoRepository.findAll();
	}
	
	public Veiculo findById(Long id) {
		return veiculoRepository.findById(id).orElse(null);
	}
	
	public Veiculo save(VeiculoDTO veiculoDto) {
		Veiculo veiculo = dtoToEntity(veiculoDto);
		return veiculoRepository.save(veiculo);
	}
	
	public void delete(Long id) {
		veiculoRepository.findById(id).ifPresent(veiculo -> {
			veiculoRepository.delete(veiculo);
		});
	}
	
	public Veiculo dtoToEntity(VeiculoDTO veiculoDto) {
		Veiculo veiculo = new Veiculo();
		Modelo modelo = modeloRepository.findById(veiculoDto.getIdModelo()).orElse(null);
		Usuario usuario = usuarioRepository.findById(veiculoDto.getIdUsuario()).orElse(null);
		
		veiculo.setIdVeiculo(veiculo.getIdVeiculo());
		veiculo.setUsuario(usuario);
		veiculo.setModelo(modelo);
		
		return veiculo;
	}
}
