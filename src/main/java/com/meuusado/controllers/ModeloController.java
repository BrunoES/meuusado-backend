package com.meuusado.controllers;

import java.net.URI;
import java.util.List;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import com.meuusado.dtos.ModeloDTO;
import com.meuusado.entities.Modelo;
import com.meuusado.services.ModeloService;

@RestController
@RequestMapping(value="/api/v1/modelo")
public class ModeloController {
	
	@Autowired
	private ModeloService modeloService;
	
	@RequestMapping(method=RequestMethod.GET)
	public ResponseEntity<List<ModeloDTO>> findAll() {
		List<Modelo> list = modeloService.findAll();
		List<ModeloDTO> listDto = list.stream().map(obj -> new ModeloDTO(obj)).collect(Collectors.toList());
		return ResponseEntity.ok().body(listDto);
	}
	
	@RequestMapping(value="/{id}", method=RequestMethod.GET)
	public ResponseEntity<ModeloDTO> find(@PathVariable Long id) {
		ModeloDTO modeloDto = new ModeloDTO(modeloService.findById(id));
		return ResponseEntity.ok().body(modeloDto);
	}
	
	@RequestMapping(method=RequestMethod.POST)
	public ResponseEntity<Modelo> save(@RequestBody ModeloDTO modeloDto) {
		Modelo modelo = modeloService.save(modeloDto);
		URI uri = ServletUriComponentsBuilder.fromCurrentRequest()
				.path("/{id}").buildAndExpand(modelo).toUri();
		return ResponseEntity.created(uri).build();
	}
	
	@RequestMapping(value="/{id}", method=RequestMethod.PUT)
	public ResponseEntity<Modelo> update(@RequestBody ModeloDTO modeloDto, @PathVariable Long id) {	
		modeloDto.setIdModelo(id);
		Modelo modelo = modeloService.update(modeloDto);
		URI uri = ServletUriComponentsBuilder.fromCurrentRequest()
				.path("/{id}").buildAndExpand(modelo).toUri();
		return ResponseEntity.created(uri).build();
	}
	
	@RequestMapping(value="/{id}", method=RequestMethod.DELETE)
	public ResponseEntity<?> delete(@PathVariable Long id) {
		modeloService.delete(id);
		return ResponseEntity.noContent().build();
	}

}
