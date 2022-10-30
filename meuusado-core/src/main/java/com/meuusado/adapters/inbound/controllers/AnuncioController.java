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

import com.meuusado.adapters.dtos.AnuncioDTO;
import com.meuusado.adapters.dtos.AnuncioResumidoDTO;
import com.meuusado.application.domain.Anuncio;
import com.meuusado.application.domain.AnuncioFotos;
import com.meuusado.application.domain.Modelo;
import com.meuusado.application.domain.Usuario;
import com.meuusado.application.domain.enums.SituacaoAnuncio;
import com.meuusado.application.ports.AnuncioServicePort;
import com.meuusado.application.ports.ModeloServicePort;
import com.meuusado.application.ports.UsuarioServicePort;

@RestController
@RequestMapping(value="/api/v1/anuncio")
public class AnuncioController {
	
	@Autowired
	private AnuncioServicePort anuncioServicePort;
	
	@Autowired
	private ModeloServicePort modeloServicePort;
	
	@Autowired
	private UsuarioServicePort usuarioServicePort;
	
	@RequestMapping(method=RequestMethod.GET)
	public ResponseEntity<List<AnuncioResumidoDTO>> findAll() {
		List<Anuncio> list = anuncioServicePort.findAll();
		List<AnuncioResumidoDTO> listDto = list.stream().filter(x -> x.base64ImgPrincMin() != null).map(obj -> new AnuncioResumidoDTO(obj)).collect(Collectors.toList());
		return ResponseEntity.ok().body(listDto);
	}
	
	@RequestMapping(value="/{id}", method=RequestMethod.GET)
	public ResponseEntity<AnuncioDTO> find(@PathVariable Long id) {
		AnuncioDTO anuncioDto = new AnuncioDTO(anuncioServicePort.findById(id));
		return ResponseEntity.ok().body(anuncioDto);
	}
	
	@RequestMapping(value="/situacao/{idSituacao}", method=RequestMethod.GET)
	public ResponseEntity<List<AnuncioResumidoDTO>> findBySituacaoAnuncio(@PathVariable int idSituacao) {
		List<Anuncio> list = anuncioServicePort.findBySituacaoAnuncio(idSituacao);
		List<AnuncioResumidoDTO> listDto = list.stream().filter(x -> x.base64ImgPrincMin() != null).map(obj -> new AnuncioResumidoDTO(obj)).collect(Collectors.toList());
		return ResponseEntity.ok().body(listDto);
	}
	
	@RequestMapping(value="/location/{coordinates}", method=RequestMethod.GET)
	public ResponseEntity<List<AnuncioResumidoDTO>> findByLocation(@PathVariable String coordinates) {
		// Implement Coordinates
		List<Anuncio> list = anuncioServicePort.findAll();
		List<AnuncioResumidoDTO> listDto = list.stream().filter(x -> x.base64ImgPrincMin() != null).map(obj -> new AnuncioResumidoDTO(obj)).collect(Collectors.toList());
		return ResponseEntity.ok().body(listDto);
	}
	
	@RequestMapping(value="/filter/{query}", method=RequestMethod.GET)
	public ResponseEntity<List<AnuncioResumidoDTO>> find(@PathVariable String query) {
		List<Anuncio> list = anuncioServicePort.findByQuery(query);
		List<AnuncioResumidoDTO> listDto = list.stream().filter(x -> x.base64ImgPrincMin() != null).map(obj -> new AnuncioResumidoDTO(obj)).collect(Collectors.toList());
		return ResponseEntity.ok().body(listDto);
	}
	
	@RequestMapping(method=RequestMethod.POST)
	public ResponseEntity<Anuncio> save(/*@Valid*/ @RequestBody AnuncioDTO anuncioDto) {
		Modelo modelo = modeloServicePort.findById(anuncioDto.getIdModelo());
		Usuario usuario = usuarioServicePort.findById(anuncioDto.getIdUsuario());
		List<AnuncioFotos> listAnuncioFotos = anuncioDto.getListAnuncioFotosBase64().stream().map(x-> new AnuncioFotos(null, null, x)).collect(Collectors.toList());
		Anuncio anuncio = new Anuncio(anuncioDto.getIdAnuncio(), usuario, modelo, anuncioDto.getTitulo(), anuncioDto.getDescricao(), anuncioDto.getAno(), anuncioDto.getValor(), anuncioDto.getDataCriacao(), anuncioDto.getBase64Imagem(), "", listAnuncioFotos, SituacaoAnuncio.AGUARDANDO_APROVACAO, anuncioDto.getCoordinates()); 
		anuncio = anuncioServicePort.save(anuncio);
		URI uri = ServletUriComponentsBuilder.fromCurrentRequest()
				.path("/{id}").buildAndExpand(anuncio.idAnuncio()).toUri();
		return ResponseEntity.created(uri).build();
	}
	
	@RequestMapping(value="/{id}", method=RequestMethod.PUT)
	public ResponseEntity<Anuncio> update(@RequestBody AnuncioDTO anuncioDto, @PathVariable Long id) {
		Modelo modelo = modeloServicePort.findById(anuncioDto.getIdModelo());
		Usuario usuario = usuarioServicePort.findById(anuncioDto.getIdUsuario());
		Anuncio anuncio = new Anuncio(id, usuario, modelo, anuncioDto.getTitulo(), anuncioDto.getDescricao(), anuncioDto.getAno(), anuncioDto.getValor(), anuncioDto.getDataCriacao(), anuncioDto.getBase64Imagem(), "", anuncioDto.getListAnuncioFotos(), anuncioDto.getSituacaoAnuncio(), anuncioDto.getCoordinates());
		anuncio = anuncioServicePort.save(anuncio);
		URI uri = ServletUriComponentsBuilder.fromCurrentRequest()
				.path("/{id}").buildAndExpand(anuncio.idAnuncio()).toUri();
		return ResponseEntity.created(uri).build();
	}
	
	@RequestMapping(value="/aprovar/{id}", method=RequestMethod.PUT)
	public ResponseEntity<Anuncio> aprove(@RequestBody AnuncioDTO anuncioDto, @PathVariable Long id) {
		Anuncio anuncio = anuncioServicePort.aprove(id);
		URI uri = ServletUriComponentsBuilder.fromCurrentRequest()
				.path("/{id}").buildAndExpand(anuncio.idAnuncio()).toUri();
		return ResponseEntity.created(uri).build();
	}
	
	@RequestMapping(value="/{id}", method=RequestMethod.DELETE)
	public ResponseEntity<?> delete(@PathVariable Long id) {
		Anuncio anuncio = anuncioServicePort.findById(id);
		anuncioServicePort.delete(anuncio);
		return ResponseEntity.noContent().build();
	}

}