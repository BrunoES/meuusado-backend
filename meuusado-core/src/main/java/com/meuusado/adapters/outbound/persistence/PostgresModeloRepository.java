package com.meuusado.adapters.outbound.persistence;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Primary;
import org.springframework.stereotype.Component;

import com.meuusado.adapters.outbound.persistence.entity.MarcaEntity;
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
	private SpringDataPostgresMarcaRepository marcaRepository;
	
	@Autowired
    private ModelMapper modelMapper;
	
	@Override
	public List<Modelo> findAll() {
		List<Modelo> listModelosDomain = new ArrayList<Modelo>();
		
		modeloRepository.findAll().forEach(modeloEntity -> {
			modeloEntity = fillModelo(modeloEntity);
			listModelosDomain.add(modeloEntity.toDomain());
		});
		
		return listModelosDomain;
	}

	@Override
	public Modelo findById(Long id) {
		ModeloEntity modeloEntity = modeloRepository.findById(id).orElse(null);
		modeloEntity = fillModelo(modeloEntity);
		return modeloEntity.toDomain();
	}

	@Override
	public Modelo save(Modelo modelo) {
		ModeloEntity modeloEntity = modelMapper.map(modelo, ModeloEntity.class);
		modeloEntity = fillModelo(modeloEntity);
		return modeloEntity.toDomain();
	}

	@Override
	public void delete(Modelo modelo) {
		ModeloEntity modeloEntity = modelMapper.map(modelo, ModeloEntity.class);
		modeloRepository.delete(modeloEntity);
	}

	@Override
	public List<Modelo> findByMarca(Marca marca) {
		/*
		 * Converter<MarcaEntity, Marca> marcaConverter = new Converter<MarcaEntity, Marca>() {
			  public Marca convert(MappingContext<MarcaEntity, Marca> context) {
			    return new Marca(context.getSource().getIdMarca(), context.getSource().getNome());
			  }
			};
		*/
		//modelMapper.addConverter(marcaConverter);
		
		/*
		modelMapper.createTypeMap(MarcaEntity.class, Marca.class).addMappings(mapper -> {
			mapper.using(marcaConverter);
		});
		*/
		//return modeloRepository.findByMarca(marca).stream().map(x -> new Modelo(x.getIdModelo(), x.getName(), new Marca(x.getMarca().getIdMarca(), x.getMarca().getNome()))).collect(Collectors.toList());
		
		MarcaEntity marcaEntity = new MarcaEntity(marca.idMarca(), marca.nome());
		return modeloRepository.findByIdMarca(marcaEntity.getIdMarca()).stream().map(x -> modelMapper.map(x, Modelo.class)).collect(Collectors.toList());

	}
	
	private ModeloEntity fillModelo(ModeloEntity modeloEntity) {
		MarcaEntity marcaEntity = marcaRepository.findById(modeloEntity.getIdMarca()).orElse(null);
		modeloEntity.setMarca(marcaEntity);
		return modeloEntity;
	}

}
