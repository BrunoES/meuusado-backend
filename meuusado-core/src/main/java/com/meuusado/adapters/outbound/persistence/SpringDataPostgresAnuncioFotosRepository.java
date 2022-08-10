package com.meuusado.adapters.outbound.persistence;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.meuusado.adapters.outbound.persistence.entity.AnuncioEntity;
import com.meuusado.adapters.outbound.persistence.entity.AnuncioFotosEntity;

public interface SpringDataPostgresAnuncioFotosRepository extends JpaRepository<AnuncioFotosEntity, Long> {

	List<AnuncioFotosEntity> findByAnuncio(AnuncioEntity anuncioEntity);
	
}
