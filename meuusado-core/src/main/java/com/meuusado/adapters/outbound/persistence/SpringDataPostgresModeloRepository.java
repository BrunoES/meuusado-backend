package com.meuusado.adapters.outbound.persistence;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.meuusado.adapters.outbound.persistence.entity.MarcaEntity;
import com.meuusado.adapters.outbound.persistence.entity.ModeloEntity;

@Repository
public interface SpringDataPostgresModeloRepository extends JpaRepository<ModeloEntity, Long> {

	List<ModeloEntity> findByMarca(MarcaEntity marcaEntity);
}
