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

import com.meuusado.dtos.UsuarioDTO;
import com.meuusado.entities.Usuario;
import com.meuusado.services.UsuarioService;

@RestController
@RequestMapping(value="/api/v1/usuario")
public class UsuarioController {
	
	@Autowired
	private UsuarioService usuarioService;
	
	@RequestMapping(method=RequestMethod.GET)
	public ResponseEntity<List<UsuarioDTO>> findAll() {
		List<Usuario> list = usuarioService.findAll();
		List<UsuarioDTO> listDto = list.stream().map(obj -> new UsuarioDTO(obj)).collect(Collectors.toList());
		return ResponseEntity.ok().body(listDto);
	}
	
	@RequestMapping(value="/{id}", method=RequestMethod.GET)
	public ResponseEntity<UsuarioDTO> find(@PathVariable Long id) {
		UsuarioDTO usuarioDto = new UsuarioDTO(usuarioService.findById(id));
		return ResponseEntity.ok().body(usuarioDto);
	}
	
	@RequestMapping(method=RequestMethod.POST)
	public ResponseEntity<Usuario> save(@RequestBody UsuarioDTO usuarioDto) {
		Usuario usuario = usuarioService.save(usuarioDto);
		URI uri = ServletUriComponentsBuilder.fromCurrentRequest()
				.path("/{id}").buildAndExpand(usuario).toUri();
		return ResponseEntity.ok().body(usuario);
		//return ResponseEntity.created(uri).build();
	}
	
	@RequestMapping(value="/{id}", method=RequestMethod.PUT)
	public ResponseEntity<Usuario> update(@RequestBody UsuarioDTO usuarioDto, @PathVariable Long id) {	
		usuarioDto.setIdUsuario(id);
		Usuario usuario = usuarioService.update(usuarioDto);
		URI uri = ServletUriComponentsBuilder.fromCurrentRequest()
				.path("/{id}").buildAndExpand(usuario).toUri();
		return ResponseEntity.created(uri).build();
	}
	
	@RequestMapping(value="/{id}", method=RequestMethod.DELETE)
	public ResponseEntity<?> delete(@PathVariable Long id) {
		usuarioService.delete(id);
		return ResponseEntity.noContent().build();
	}

}
