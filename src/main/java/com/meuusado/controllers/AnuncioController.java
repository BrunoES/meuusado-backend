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

import com.meuusado.dtos.AnuncioDTO;
import com.meuusado.entities.Anuncio;
import com.meuusado.services.AnuncioService;

@RestController
@RequestMapping(value="/api/v1/anuncio")
public class AnuncioController {
	
	@Autowired
	private AnuncioService anuncioService;
	
	@RequestMapping(method=RequestMethod.GET)
	public ResponseEntity<List<AnuncioDTO>> findAll() {
		List<Anuncio> list = anuncioService.findAll();
		List<AnuncioDTO> listDto = list.stream().map(obj -> new AnuncioDTO(obj)).collect(Collectors.toList());
		return ResponseEntity.ok().body(listDto);
	}
	
	@RequestMapping(value="/{id}", method=RequestMethod.GET)
	public ResponseEntity<AnuncioDTO> find(@PathVariable Long id) {
		AnuncioDTO anuncioDto = new AnuncioDTO(anuncioService.findById(id));
		return ResponseEntity.ok().body(anuncioDto);
	}
	
	@RequestMapping(method=RequestMethod.POST)
	public ResponseEntity<Anuncio> save(@RequestBody AnuncioDTO anuncioDto) {
		Anuncio anuncio = anuncioService.save(anuncioDto);
		URI uri = ServletUriComponentsBuilder.fromCurrentRequest()
				.path("/{id}").buildAndExpand(anuncio).toUri();
		return ResponseEntity.created(uri).build();
	}
	
	@RequestMapping(value="/{id}", method=RequestMethod.PUT)
	public ResponseEntity<Anuncio> update(@RequestBody AnuncioDTO anuncioDto, @PathVariable Long id) {	
		anuncioDto.setIdAnuncio(id);
		Anuncio anuncio = anuncioService.update(anuncioDto);
		URI uri = ServletUriComponentsBuilder.fromCurrentRequest()
				.path("/{id}").buildAndExpand(anuncio).toUri();
		return ResponseEntity.created(uri).build();
	}
	
	@RequestMapping(value="/{id}", method=RequestMethod.DELETE)
	public ResponseEntity<?> delete(@PathVariable Long id) {
		anuncioService.delete(id);
		return ResponseEntity.noContent().build();
	}

}
