package com.meuusado.adapters.outbound.persistence;

import java.util.List;

import javax.transaction.Transactional;

import org.springframework.data.jpa.repository.JpaRepository;

import com.meuusado.adapters.outbound.persistence.entity.AnuncioFotosEntity;

@Transactional
public interface SpringDataPostgresAnuncioFotosRepository extends JpaRepository<AnuncioFotosEntity, Long> {

	List<AnuncioFotosEntity> findByIdAnuncio(Long idAnuncio);
	
}