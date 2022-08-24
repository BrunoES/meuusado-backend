package com.meuusado.adapters.outbound.persistence;

import java.util.ArrayList;
import java.util.List;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Primary;
import org.springframework.stereotype.Component;

import com.meuusado.adapters.outbound.persistence.entity.AnuncioEntity;
import com.meuusado.application.domain.Anuncio;
import com.meuusado.application.domain.AnuncioFotos;
import com.meuusado.application.domain.Modelo;
import com.meuusado.application.domain.Usuario;
import com.meuusado.application.domain.enums.SituacaoAnuncio;
import com.meuusado.application.ports.AnuncioRepositoryPort;

@Component
@Primary
public class PostgresAnuncioRepository implements AnuncioRepositoryPort {

	@Autowired
	private SpringDataPostgresAnuncioRepository anuncioRepository;
	
	@Autowired
	private PostgresAnuncioFotosRepository anuncioFotosRepository;
	
	@Autowired
	private PostgresModeloRepository modeloRepository;
	
	@Autowired
	private PostgresUsuarioRepository usuarioRepository;
	
	@Autowired
    private ModelMapper modelMapper;
	
	@Override
	public List<Anuncio> findAll() {
		List<Anuncio> listAnunciosDomain = new ArrayList<Anuncio>();
		
		anuncioRepository.findAll().forEach(anuncioEntity -> {
			listAnunciosDomain.add(fillAnuncio(anuncioEntity));
		});
		
		return listAnunciosDomain;
	}

	@Override
	public Anuncio findById(Long id) {
		AnuncioEntity anuncioEntity = anuncioRepository.findById(id).orElse(null);
		return fillAnuncio(anuncioEntity);
	}

	@Override
	public Anuncio save(Anuncio anuncio) {
		AnuncioEntity anuncioEntity = new AnuncioEntity();
		
		anuncioEntity.setIdAnuncio(anuncio.idAnuncio());
		anuncioEntity.setTitulo(anuncio.titulo());
		anuncioEntity.setDescricao(anuncio.descricao());
		anuncioEntity.setValor(anuncio.valor());
		anuncioEntity.setAno(anuncio.ano());
		anuncioEntity.setIdModelo(anuncio.modelo().idModelo());
		anuncioEntity.setIdUsuario(anuncio.usuario().idUsuario());
		anuncioEntity.setBase64ImgPrincMin(anuncio.base64ImgPrincMin());
		anuncioEntity.setSituacaoAnuncio(anuncio.situacaoAnuncio().situacaoAnuncio);
		
		anuncioEntity = anuncioRepository.save(anuncioEntity);
		
		anuncio.listAnuncioFotos().stream().forEach(anuncioFoto -> {
			anuncioFotosRepository.save(anuncioFoto);
		});
		
		return fillAnuncio(anuncioEntity);
	}

	@Override
	public void delete(Anuncio anuncio) {
		AnuncioEntity anuncioEntity = modelMapper.map(anuncio, AnuncioEntity.class);
		anuncioRepository.delete(anuncioEntity);
	}
	
	private Anuncio fillAnuncio(AnuncioEntity anuncioEntity) {
		List<AnuncioFotos> listFotosAnuncio = anuncioFotosRepository.findByAnuncio(anuncioEntity.getIdAnuncio());
		Modelo modelo = (anuncioEntity.getIdModelo() != null ? modeloRepository.findById(anuncioEntity.getIdModelo()) : null);
		Usuario usuario = (anuncioEntity.getIdUsuario() != null ? usuarioRepository.findById(anuncioEntity.getIdUsuario()) : null);
		Anuncio anuncio = new Anuncio(anuncioEntity.getIdAnuncio(), usuario, modelo, anuncioEntity.getTitulo(), anuncioEntity.getDescricao(), anuncioEntity.getAno(), anuncioEntity.getValor(), anuncioEntity.getDataCriacao(), anuncioEntity.getBase64ImgPrincMin(), anuncioEntity.getPathImagem(), listFotosAnuncio, SituacaoAnuncio.valueOf(anuncioEntity.getSituacaoAnuncio())); 
		return anuncio;
	}

}
