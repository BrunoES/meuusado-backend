package com.meuusado.adapters.inbound.controllers;

import java.net.URI;
import java.util.List;
import java.util.stream.Collectors;

import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import com.meuusado.adapters.dtos.ModeloDTO;
import com.meuusado.application.domain.Marca;
import com.meuusado.application.domain.Modelo;
import com.meuusado.application.ports.MarcaServicePort;
import com.meuusado.application.ports.ModeloServicePort;

@RestController
@RequestMapping(value="/api/v1/modelo")
public class ModeloController {
	
	@Autowired
	private ModeloServicePort modeloServicePort;
	
	@Autowired
	private MarcaServicePort marcaServicePort;
	
	@RequestMapping(method=RequestMethod.GET)
	public ResponseEntity<List<ModeloDTO>> findAll() {
		List<Modelo> list = modeloServicePort.findAll();
		List<ModeloDTO> listDto = list.stream().map(obj -> new ModeloDTO(obj)).collect(Collectors.toList());
		return ResponseEntity.ok().body(listDto);
	}
	
	@RequestMapping(value="/{id}", method=RequestMethod.GET)
	public ResponseEntity<ModeloDTO> find(@PathVariable Long id) {
		ModeloDTO modeloDto = new ModeloDTO(modeloServicePort.findById(id));
		return ResponseEntity.ok().body(modeloDto);
	}
	
	@RequestMapping(value="/marca/{idMarca}", method=RequestMethod.GET)
	public ResponseEntity<List<ModeloDTO>> findByMarca(@PathVariable Long idMarca) {
		Marca marca = marcaServicePort.findById(idMarca);
		List<Modelo> list = modeloServicePort.findByMarca(marca);
		List<ModeloDTO> listDto = list.stream().map(obj -> new ModeloDTO(obj)).collect(Collectors.toList());
		return ResponseEntity.ok().body(listDto);
	}
	
	@RequestMapping(method=RequestMethod.POST)
	public ResponseEntity<Modelo> save(@RequestBody ModeloDTO modeloDto) {
		Marca marca = marcaServicePort.findById(modeloDto.getIdMarca());
		Modelo modelo = new Modelo(modeloDto.getIdModelo(), modeloDto.getNomeModelo(), marca); 
		modelo = modeloServicePort.save(modelo);
		URI uri = ServletUriComponentsBuilder.fromCurrentRequest()
				.path("/{id}").buildAndExpand(modelo.idModelo()).toUri();
		return ResponseEntity.created(uri).build();
	}
	
	@RequestMapping(value="/{id}", method=RequestMethod.PUT)
	public ResponseEntity<Modelo> update(@RequestBody ModeloDTO modeloDto, @PathVariable Long id) {	
		Marca marca = marcaServicePort.findById(modeloDto.getIdMarca());
		Modelo modelo = new Modelo(id, modeloDto.getNomeModelo(), marca);
		modelo = modeloServicePort.update(modelo);
		URI uri = ServletUriComponentsBuilder.fromCurrentRequest()
				.path("/{id}").buildAndExpand(modelo.idModelo()).toUri();
		return ResponseEntity.created(uri).build();
	}
	
	@RequestMapping(value="/{id}", method=RequestMethod.DELETE)
	public ResponseEntity<?> delete(@PathVariable Long id) {
		Modelo modelo = modeloServicePort.findById(id);
		modeloServicePort.delete(modelo);
		return ResponseEntity.noContent().build();
	}

}
