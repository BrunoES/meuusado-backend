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

import com.meuusado.adapters.dtos.UsuarioDTO;
import com.meuusado.application.domain.Usuario;
import com.meuusado.application.ports.UsuarioServicePort;

@RestController
@RequestMapping(value="/api/v1/usuario")
public class UsuarioController {
	
	@Autowired
	private UsuarioServicePort usuarioServicePort;
	
	@RequestMapping(method=RequestMethod.GET)
	public ResponseEntity<List<UsuarioDTO>> findAll() {
		List<Usuario> list = usuarioServicePort.findAll();
		List<UsuarioDTO> listDto = list.stream().map(obj -> new UsuarioDTO(obj)).collect(Collectors.toList());
		return ResponseEntity.ok().body(listDto);
	}
	
	@RequestMapping(value="/{id}", method=RequestMethod.GET)
	public ResponseEntity<UsuarioDTO> find(@PathVariable Long id) {
		UsuarioDTO usuarioDto = new UsuarioDTO(usuarioServicePort.findById(id));
		return ResponseEntity.ok().body(usuarioDto);
	}
	
	@RequestMapping(method=RequestMethod.POST)
	public ResponseEntity<Usuario> save(@RequestBody UsuarioDTO usuarioDto) {
		Usuario usuario = new Usuario(usuarioDto.getIdUsuario(), usuarioDto.getNome(), usuarioDto.getEmail(), usuarioDto.getPassword());
		usuario = usuarioServicePort.save(usuario);
		URI uri = ServletUriComponentsBuilder.fromCurrentRequest()
				.path("/{id}").buildAndExpand(usuario.idUsuario()).toUri();
		return ResponseEntity.ok().body(usuario);
		//return ResponseEntity.created(uri).build();
	}
	
	@RequestMapping(value="/{id}", method=RequestMethod.PUT)
	public ResponseEntity<Usuario> update(@RequestBody UsuarioDTO usuarioDto, @PathVariable Long id) {
		Usuario usuario = new Usuario(id, usuarioDto.getNome(), usuarioDto.getEmail(), usuarioDto.getPassword());
		usuario = usuarioServicePort.update(usuario);
		URI uri = ServletUriComponentsBuilder.fromCurrentRequest()
				.path("/{id}").buildAndExpand(usuario.idUsuario()).toUri();
		return ResponseEntity.created(uri).build();
	}
	
	@RequestMapping(value="/{id}", method=RequestMethod.DELETE)
	public ResponseEntity<?> delete(@PathVariable Long id) {
		Usuario usuario = usuarioServicePort.findById(id);
		usuarioServicePort.delete(usuario);
		return ResponseEntity.noContent().build();
	}

}
