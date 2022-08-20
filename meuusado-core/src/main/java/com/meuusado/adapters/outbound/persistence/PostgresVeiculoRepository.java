package com.meuusado.adapters.outbound.persistence;

import java.util.ArrayList;
import java.util.List;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Primary;
import org.springframework.stereotype.Component;

import com.meuusado.adapters.outbound.persistence.entity.ModeloEntity;
import com.meuusado.adapters.outbound.persistence.entity.UsuarioEntity;
import com.meuusado.adapters.outbound.persistence.entity.VeiculoEntity;
import com.meuusado.application.domain.Veiculo;
import com.meuusado.application.ports.VeiculoRepositoryPort;

@Component
@Primary
public class PostgresVeiculoRepository implements VeiculoRepositoryPort {

	@Autowired
	private SpringDataPostgresVeiculoRepository veiculoRepository;
	
	@Autowired
	private SpringDataPostgresModeloRepository modeloRepository;
	
	@Autowired
	private SpringDataPostgresUsuarioRepository usuarioRepository;
	
	@Autowired
    private ModelMapper modelMapper;
	
	@Override
	public List<Veiculo> findAll() {
		List<Veiculo> listVeiculosDomain = new ArrayList<Veiculo>();
		
		veiculoRepository.findAll().forEach(veiculoEntity -> {
			veiculoEntity = fillVeiculo(veiculoEntity);
			listVeiculosDomain.add(veiculoEntity.toDomain());
		});
		
		return listVeiculosDomain;
	}

	@Override
	public Veiculo findById(Long id) {
		VeiculoEntity veiculoEntity = veiculoRepository.findById(id).orElse(null);
		veiculoEntity = fillVeiculo(veiculoEntity);
		return veiculoEntity.toDomain();
	}

	@Override
	public Veiculo save(Veiculo veiculo) {
		VeiculoEntity veiculoEntity = modelMapper.map(veiculo, VeiculoEntity.class);
		veiculoEntity = fillVeiculo(veiculoEntity);
		return veiculoEntity.toDomain();
	}

	@Override
	public void delete(Veiculo veiculo) {
		VeiculoEntity VeiculoEntity = modelMapper.map(veiculo, VeiculoEntity.class);
		veiculoRepository.delete(VeiculoEntity);
	}
	
	private VeiculoEntity fillVeiculo(VeiculoEntity veiculoEntity) {
		ModeloEntity modeloEntity = modeloRepository.findById(veiculoEntity.getIdModelo()).orElse(null);
		UsuarioEntity usuarioEntity = usuarioRepository.findById(veiculoEntity.getIdUsuario()).orElse(null);
		veiculoEntity.setModelo(modeloEntity);
		veiculoEntity.setUsuario(usuarioEntity);
		return veiculoEntity;
	}

}
