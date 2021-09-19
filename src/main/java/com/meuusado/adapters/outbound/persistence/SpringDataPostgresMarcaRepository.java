package com.meuusado.adapters.outbound.persistence;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.meuusado.adapters.outbound.persistence.entity.MarcaEntity;

@Repository
public interface SpringDataPostgresMarcaRepository extends JpaRepository<MarcaEntity, Long> {

}
