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

import com.meuusado.dtos.VeiculoDTO;
import com.meuusado.entities.Veiculo;
import com.meuusado.services.VeiculoService;

@RestController
@RequestMapping(value="/api/v1/veiculo")
public class VeiculoController {
	
	@Autowired
	private VeiculoService veiculoService;
	
	@RequestMapping(method=RequestMethod.GET)
	public ResponseEntity<List<VeiculoDTO>> findAll() {
		List<Veiculo> list = veiculoService.findAll();
		List<VeiculoDTO> listDto = list.stream().map(obj -> new VeiculoDTO(obj)).collect(Collectors.toList());
		return ResponseEntity.ok().body(listDto);
	}
	
	@RequestMapping(value="/{id}", method=RequestMethod.GET)
	public ResponseEntity<VeiculoDTO> find(@PathVariable Long id) {
		VeiculoDTO veiculoDto = new VeiculoDTO(veiculoService.findById(id));
		return ResponseEntity.ok().body(veiculoDto);
	}
	
	@RequestMapping(method=RequestMethod.POST)
	public ResponseEntity<Veiculo> save(@RequestBody VeiculoDTO veiculoDto) {
		Veiculo veiculo = veiculoService.save(veiculoDto);
		URI uri = ServletUriComponentsBuilder.fromCurrentRequest()
				.path("/{id}").buildAndExpand(veiculo).toUri();
		return ResponseEntity.created(uri).build();
	}
	
	@RequestMapping(value="/{id}", method=RequestMethod.PUT)
	public ResponseEntity<Veiculo> update(@RequestBody VeiculoDTO veiculoDto, @PathVariable Long id) {	
		veiculoDto.setIdVeiculo(id);
		Veiculo veiculo = veiculoService.update(veiculoDto);
		URI uri = ServletUriComponentsBuilder.fromCurrentRequest()
				.path("/{id}").buildAndExpand(veiculo).toUri();
		return ResponseEntity.created(uri).build();
	}
	
	@RequestMapping(value="/{id}", method=RequestMethod.DELETE)
	public ResponseEntity<?> delete(@PathVariable Long id) {
		veiculoService.delete(id);
		return ResponseEntity.noContent().build();
	}

}
