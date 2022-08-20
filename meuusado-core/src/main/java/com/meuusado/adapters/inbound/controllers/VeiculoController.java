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

import com.meuusado.adapters.dtos.VeiculoDTO;
import com.meuusado.application.domain.Cor;
import com.meuusado.application.domain.Modelo;
import com.meuusado.application.domain.Placa;
import com.meuusado.application.domain.Usuario;
import com.meuusado.application.domain.Veiculo;
import com.meuusado.application.ports.ModeloServicePort;
import com.meuusado.application.ports.UsuarioServicePort;
import com.meuusado.application.ports.VeiculoServicePort;

@RestController
@RequestMapping(value="/api/v1/veiculo")
public class VeiculoController {
	
	@Autowired
	private VeiculoServicePort veiculoServicePort;
	
	@Autowired
	private ModeloServicePort modeloServicePort;
	
	@Autowired
	private UsuarioServicePort usuarioServicePort;
	
	@RequestMapping(method=RequestMethod.GET)
	public ResponseEntity<List<VeiculoDTO>> findAll() {
		List<Veiculo> list = veiculoServicePort.findAll();
		List<VeiculoDTO> listDto = list.stream().map(obj -> new VeiculoDTO(obj)).collect(Collectors.toList());
		return ResponseEntity.ok().body(listDto);
	}
	
	@RequestMapping(value="/{id}", method=RequestMethod.GET)
	public ResponseEntity<VeiculoDTO> find(@PathVariable Long id) {
		VeiculoDTO veiculoDto = new VeiculoDTO(veiculoServicePort.findById(id));
		return ResponseEntity.ok().body(veiculoDto);
	}
	
	@RequestMapping(method=RequestMethod.POST)
	public ResponseEntity<Veiculo> save(@RequestBody VeiculoDTO veiculoDto) {
		Modelo modelo = modeloServicePort.findById(veiculoDto.getIdModelo());
		Usuario usuario = usuarioServicePort.findById(veiculoDto.getIdUsuario());
		Veiculo veiculo = new Veiculo(veiculoDto.getIdVeiculo(), usuario, modelo, new Placa(veiculoDto.getPlaca(), new Cor("Azul")));
		veiculo = veiculoServicePort.save(veiculo);
		URI uri = ServletUriComponentsBuilder.fromCurrentRequest()
				.path("/{id}").buildAndExpand(veiculo.idVeiculo()).toUri();
		return ResponseEntity.created(uri).build();
	}
	
	@RequestMapping(value="/{id}", method=RequestMethod.PUT)
	public ResponseEntity<Veiculo> update(@RequestBody VeiculoDTO veiculoDto, @PathVariable Long id) {
		Modelo modelo = modeloServicePort.findById(veiculoDto.getIdModelo());
		Usuario usuario = usuarioServicePort.findById(veiculoDto.getIdUsuario());
		Veiculo veiculo = new Veiculo(id, usuario, modelo, new Placa(veiculoDto.getPlaca(), new Cor("Azul")));
		veiculo = veiculoServicePort.update(veiculo);
		URI uri = ServletUriComponentsBuilder.fromCurrentRequest()
				.path("/{id}").buildAndExpand(veiculo.idVeiculo()).toUri();
		return ResponseEntity.created(uri).build();
	}
	
	@RequestMapping(value="/{id}", method=RequestMethod.DELETE)
	public ResponseEntity<?> delete(@PathVariable Long id) {
		Veiculo veiculo = veiculoServicePort.findById(id);
		veiculoServicePort.delete(veiculo);
		return ResponseEntity.noContent().build();
	}

}
