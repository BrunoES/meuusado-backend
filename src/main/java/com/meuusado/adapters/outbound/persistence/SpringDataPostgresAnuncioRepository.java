package com.meuusado.adapters.outbound.persistence;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.meuusado.adapters.outbound.persistence.entity.AnuncioEntity;

@Repository
public interface SpringDataPostgresAnuncioRepository extends JpaRepository<AnuncioEntity, Long> {

}
