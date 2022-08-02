package com.meuusado.adapters.inbound.controllers;

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

import com.meuusado.adapters.dtos.MarcaDTO;
import com.meuusado.application.domain.Marca;
import com.meuusado.application.ports.MarcaServicePort;

@RestController
@RequestMapping(value="/api/v1/marca")
public class MarcaController {
	
	@Autowired
	private MarcaServicePort marcaServicePort;
	
	@RequestMapping(method=RequestMethod.GET)
	public ResponseEntity<List<MarcaDTO>> findAll() {
		List<Marca> list = marcaServicePort.findAll();
		List<MarcaDTO> listDto = list.stream().map(obj -> new MarcaDTO(obj)).collect(Collectors.toList());
		return ResponseEntity.ok().body(listDto);
	}
	
	@RequestMapping(value="/{id}", method=RequestMethod.GET)
	public ResponseEntity<MarcaDTO> find(@PathVariable Long id) {
		MarcaDTO marcaDto = new MarcaDTO(marcaServicePort.findById(id));
		return ResponseEntity.ok().body(marcaDto);
	}
	
	@RequestMapping(method=RequestMethod.POST)
	public ResponseEntity<Marca> save(@RequestBody MarcaDTO marcaDto) {
		Marca marca = new Marca(marcaDto.getIdMarca(), marcaDto.getNome());
		marca = marcaServicePort.save(marca);
		URI uri = ServletUriComponentsBuilder.fromCurrentRequest()
				.path("/{id}").buildAndExpand(marca).toUri();
		return ResponseEntity.created(uri).build();
	}
	
	@RequestMapping(value="/{id}", method=RequestMethod.PUT)
	public ResponseEntity<Marca> update(@RequestBody MarcaDTO marcaDto, @PathVariable Long id) {
		Marca marca = new Marca(id, marcaDto.getNome());
		marca = marcaServicePort.update(marca);
		URI uri = ServletUriComponentsBuilder.fromCurrentRequest()
				.path("/{id}").buildAndExpand(marca).toUri();
		return ResponseEntity.created(uri).build();
	}
	
	@RequestMapping(value="/{id}", method=RequestMethod.DELETE)
	public ResponseEntity<?> delete(@PathVariable Long id) {
		Marca marca = marcaServicePort.findById(id);
		marcaServicePort.delete(marca);
		return ResponseEntity.noContent().build();
	}

}
