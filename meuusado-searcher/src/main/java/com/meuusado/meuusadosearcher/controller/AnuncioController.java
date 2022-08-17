package com.meuusado.meuusadosearcher.controller;

import java.util.List;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.meuusado.meuusadosearcher.domain.Anuncio;
import com.meuusado.meuusadosearcher.dto.AnuncioResumidoDTO;
import com.meuusado.meuusadosearcher.service.AnuncioService;

@Controller
public class AnuncioController {
	
	@Autowired
	private AnuncioService anuncioService;
	
	@RequestMapping(value="/filter/{query}", method=RequestMethod.GET)
	public ResponseEntity<List<AnuncioResumidoDTO>> find(@PathVariable String query) {
		List<Anuncio> list = anuncioService.findByQuery(query);
		List<AnuncioResumidoDTO> listDto = list.stream().filter(x -> x.base64ImgPrincMin() != null).map(obj -> new AnuncioResumidoDTO(obj)).collect(Collectors.toList());
		return ResponseEntity.ok().body(listDto);
	}

}
