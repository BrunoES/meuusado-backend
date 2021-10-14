package com.meuusado.adapters.inbound.controllers;

import java.net.URI;
import java.util.List;
import java.util.stream.Collectors;

import javax.validation.Valid;

import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import com.meuusado.adapters.dtos.AnuncioDTO;
import com.meuusado.adapters.dtos.AnuncioResumidoDTO;
import com.meuusado.application.domain.Anuncio;
import com.meuusado.application.ports.AnuncioServicePort;

@RestController
@RequestMapping(value="/api/v1/anuncio")
public class AnuncioController {
	
	@Autowired
	private AnuncioServicePort anuncioServicePort;
	
	@RequestMapping(method=RequestMethod.GET)
	public ResponseEntity<List<AnuncioResumidoDTO>> findAll() {
		List<Anuncio> list = anuncioServicePort.findAll();
		List<AnuncioResumidoDTO> listDto = list.stream().map(obj -> new AnuncioResumidoDTO(obj)).collect(Collectors.toList());
		return ResponseEntity.ok().body(listDto);
	}
	
	@RequestMapping(value="/{id}", method=RequestMethod.GET)
	public ResponseEntity<AnuncioDTO> find(@PathVariable Long id) {
		AnuncioDTO anuncioDto = new AnuncioDTO(anuncioServicePort.findById(id));
		return ResponseEntity.ok().body(anuncioDto);
	}
	
	@RequestMapping(method=RequestMethod.POST)
	public ResponseEntity<Anuncio> save(/*@Valid*/ @RequestBody AnuncioDTO anuncioDto) {
		Anuncio anuncio = new Anuncio(); 
		BeanUtils.copyProperties(anuncioDto, anuncio);
		anuncio = anuncioServicePort.save(anuncio);
		URI uri = ServletUriComponentsBuilder.fromCurrentRequest()
				.path("/{id}").buildAndExpand(anuncio).toUri();
		return ResponseEntity.created(uri).build();
	}
	
	@RequestMapping(value="/{id}", method=RequestMethod.PUT)
	public ResponseEntity<Anuncio> update(@RequestBody AnuncioDTO anuncioDto, @PathVariable Long id) {
		Anuncio anuncio = new Anuncio(); 
		anuncioDto.setIdAnuncio(id);
		BeanUtils.copyProperties(anuncioDto, anuncio);
		anuncio = anuncioServicePort.save(anuncio);
		URI uri = ServletUriComponentsBuilder.fromCurrentRequest()
				.path("/{id}").buildAndExpand(anuncio).toUri();
		return ResponseEntity.created(uri).build();
	}
	
	@RequestMapping(value="/{id}", method=RequestMethod.DELETE)
	public ResponseEntity<?> delete(@PathVariable Long id) {
		Anuncio anuncio = new Anuncio();
		anuncio = anuncioServicePort.findById(id);
		anuncioServicePort.delete(anuncio);
		return ResponseEntity.noContent().build();
	}

}