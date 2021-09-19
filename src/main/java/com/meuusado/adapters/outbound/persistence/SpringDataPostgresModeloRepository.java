package com.meuusado.adapters.outbound.persistence;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.meuusado.adapters.outbound.persistence.entity.ModeloEntity;
import com.meuusado.application.domain.Marca;
import com.meuusado.application.domain.Modelo;

@Repository
public interface SpringDataPostgresModeloRepository extends JpaRepository<ModeloEntity, Long> {

	List<Modelo> findByMarca(Marca marca);
}
