package com.meuusado.adapters.outbound.persistence;

import java.util.List;
import java.util.stream.Collectors;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Primary;
import org.springframework.stereotype.Component;

import com.meuusado.adapters.outbound.persistence.entity.VeiculoEntity;
import com.meuusado.application.domain.Veiculo;
import com.meuusado.application.ports.VeiculoRepositoryPort;

@Component
@Primary
public class PostgresVeiculoRepository implements VeiculoRepositoryPort {

	@Autowired
	private SpringDataPostgresVeiculoRepository veiculoRepository;
	
	@Autowired
    private ModelMapper modelMapper;
	
	@Override
	public List<Veiculo> findAll() {
		return veiculoRepository.findAll().stream().map(x -> modelMapper.map(x, Veiculo.class)).collect(Collectors.toList());
	}

	@Override
	public Veiculo findById(Long id) {
		VeiculoEntity VeiculoEntity = veiculoRepository.findById(id).orElse(null);
		return modelMapper.map(VeiculoEntity, Veiculo.class);
	}

	@Override
	public Veiculo save(Veiculo veiculo) {
		VeiculoEntity VeiculoEntity = modelMapper.map(veiculo, VeiculoEntity.class);
		return modelMapper.map(veiculoRepository.save(VeiculoEntity), Veiculo.class);
	}

	@Override
	public void delete(Veiculo veiculo) {
		VeiculoEntity VeiculoEntity = modelMapper.map(veiculo, VeiculoEntity.class);
		veiculoRepository.delete(VeiculoEntity);
	}

}
