package com.meuusado.adapters.outbound.persistence;

import java.util.ArrayList;
import java.util.List;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Primary;
import org.springframework.stereotype.Component;

import com.meuusado.adapters.outbound.persistence.entity.ModeloEntity;
import com.meuusado.application.domain.Marca;
import com.meuusado.application.domain.Modelo;
import com.meuusado.application.ports.ModeloRepositoryPort;

@Component
@Primary
public class PostgresModeloRepository implements ModeloRepositoryPort {

	@Autowired
	private SpringDataPostgresModeloRepository modeloRepository;
	
	@Autowired
	private PostgresMarcaRepository marcaRepository;
	
	@Autowired
    private ModelMapper modelMapper;
	
	@Override
	public List<Modelo> findAll() {
		List<Modelo> listModelosDomain = new ArrayList<Modelo>();
		
		modeloRepository.findAll().forEach(modeloEntity -> {
			listModelosDomain.add(fillModelo(modeloEntity));
		});
		
		return listModelosDomain;
	}

	@Override
	public Modelo findById(Long id) {
		ModeloEntity modeloEntity = modeloRepository.findById(id).orElse(null);
		return fillModelo(modeloEntity);
	}

	@Override
	public Modelo save(Modelo modelo) {
		ModeloEntity modeloEntity = new ModeloEntity();
		modeloEntity.setIdMarca(modelo.marca().idMarca());
		modeloEntity.setName(modelo.nome());
		modeloEntity = modeloRepository.save(modeloEntity);
		return fillModelo(modeloEntity);
	}

	@Override
	public void delete(Modelo modelo) {
		ModeloEntity modeloEntity = modelMapper.map(modelo, ModeloEntity.class);
		modeloRepository.delete(modeloEntity);
	}

	@Override
	public List<Modelo> findByIdMarca(Long IdMarca) {
		List<Modelo> listModelosDomain = new ArrayList<Modelo>();
		
		modeloRepository.findByIdMarca(IdMarca).forEach(modeloEntity -> {
			listModelosDomain.add(fillModelo(modeloEntity));
		});
		
		return listModelosDomain;
		
	}
	
	private Modelo fillModelo(ModeloEntity modeloEntity) {
		Marca marca = marcaRepository.findById(modeloEntity.getIdMarca());
		Modelo modelo = new Modelo(modeloEntity.getIdModelo(), modeloEntity.getName(), marca);
		return modelo;
	}

}
