package com.meuusado.business;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.meuusado.dtos.AnuncioDTO;
import com.meuusado.entities.Anuncio;
import com.meuusado.repository.AnuncioRepository;
import com.meuusado.repository.UsuarioRepository;
import com.meuusado.repository.VeiculoRepository;

@Component
public class AnuncioBusiness {

	@Autowired
	private AnuncioRepository anuncioRepository;
	
	@Autowired
	private UsuarioRepository usuarioRepository;
	
	@Autowired
	private VeiculoRepository veiculoRepository;
	
	public List<Anuncio> findAll() {
		return anuncioRepository.findAll();
	}
	
	public Anuncio findById(Long id) {
		return anuncioRepository.findById(id).orElse(null);
	}
	
	public Anuncio save(AnuncioDTO anuncioDto) {
		Anuncio anuncio = dtoToEntity(anuncioDto);
		return anuncioRepository.save(anuncio);
	}
	
	public void delete(Long id) {
		anuncioRepository.findById(id).ifPresent(anuncio -> {
			anuncioRepository.delete(anuncio);
		});
	}
	
	public Anuncio dtoToEntity(AnuncioDTO anuncioDto) {
		Anuncio anuncio = new Anuncio();
		
		anuncio.setIdAnuncio(anuncioDto.getIdAnuncio());
		anuncio.setUsuario(usuarioRepository.findById(anuncioDto.getIdUsuario()).orElse(null));
		anuncio.setVeiculo(veiculoRepository.findById(anuncioDto.getIdVeiculo()).orElse(null));
		anuncio.setTitulo(anuncioDto.getTitulo());
		anuncio.setDescricao(anuncioDto.getDescricao());
		anuncio.setPathImagem("C://user//bruno//tmp//");
		anuncio.setDataCriacao(anuncioDto.getDataCriacao());
		
		return anuncio;
	}
}
