package com.meuusado.adapters.outbound.persistence;

import java.util.List;

import javax.transaction.Transactional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.meuusado.adapters.outbound.persistence.entity.AnuncioEntity;

@Transactional
@Repository
public interface SpringDataPostgresAnuncioRepository extends JpaRepository<AnuncioEntity, Long> {

	List<AnuncioEntity> findBySituacaoAnuncio(int i);

}
