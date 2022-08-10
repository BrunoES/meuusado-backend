package com.meuusado.adapters.outbound.persistence;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.meuusado.adapters.outbound.persistence.entity.VeiculoEntity;

@Repository
public interface SpringDataPostgresVeiculoRepository extends JpaRepository<VeiculoEntity, Long> {

}
