package com.meuusado.adapters.outbound.persistence;

import java.util.ArrayList;
import java.util.List;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Primary;
import org.springframework.stereotype.Component;

import com.meuusado.adapters.outbound.persistence.entity.VeiculoEntity;
import com.meuusado.application.domain.Modelo;
import com.meuusado.application.domain.Usuario;
import com.meuusado.application.domain.Veiculo;
import com.meuusado.application.ports.VeiculoRepositoryPort;

@Component
@Primary
public class PostgresVeiculoRepository implements VeiculoRepositoryPort {

	@Autowired
	private SpringDataPostgresVeiculoRepository veiculoRepository;
	
	@Autowired
	private PostgresModeloRepository modeloRepository;
	
	@Autowired
	private PostgresUsuarioRepository usuarioRepository;
	
	@Autowired
    private ModelMapper modelMapper;
	
	@Override
	public List<Veiculo> findAll() {
		List<Veiculo> listVeiculosDomain = new ArrayList<Veiculo>();
		
		veiculoRepository.findAll().forEach(veiculoEntity -> {
			listVeiculosDomain.add(fillVeiculo(veiculoEntity));
		});
		
		return listVeiculosDomain;
	}

	@Override
	public Veiculo findById(Long id) {
		VeiculoEntity veiculoEntity = veiculoRepository.findById(id).orElse(null);
		return fillVeiculo(veiculoEntity);
	}

	@Override
	public Veiculo save(Veiculo veiculo) {
		VeiculoEntity veiculoEntity = new VeiculoEntity();
		veiculoEntity.setIdModelo(veiculo.modelo().idModelo());
		veiculoEntity.setIdUsuario(veiculo.usuario().idUsuario());
		veiculoEntity = veiculoRepository.save(veiculoEntity);
		return fillVeiculo(veiculoEntity);
	}

	@Override
	public void delete(Veiculo veiculo) {
		VeiculoEntity VeiculoEntity = modelMapper.map(veiculo, VeiculoEntity.class);
		veiculoRepository.delete(VeiculoEntity);
	}
	
	/*
	private VeiculoEntity fillVeiculo(VeiculoEntity veiculoEntity) {
		ModeloEntity modeloEntity = modeloRepository.findById(veiculoEntity.getIdModelo()).orElse(null);
		UsuarioEntity usuarioEntity = usuarioRepository.findById(veiculoEntity.getIdUsuario()).orElse(null);
		veiculoEntity.setModelo(modeloEntity);
		veiculoEntity.setUsuario(usuarioEntity);
		
		Veiculo veiculo = new Veiculo(null, null, null, null)
		
		return veiculoEntity;
	}
	*/
	
	private Veiculo fillVeiculo(VeiculoEntity veiculoEntity) {
		Modelo modelo = modeloRepository.findById(veiculoEntity.getIdModelo());
		Usuario usuario = usuarioRepository.findById(veiculoEntity.getIdUsuario());
		Veiculo veiculo = new Veiculo(veiculoEntity.getIdVeiculo(), usuario, modelo, null);
		return veiculo;
	}

}
