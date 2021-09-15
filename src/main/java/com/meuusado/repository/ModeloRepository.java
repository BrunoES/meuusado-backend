package com.meuusado.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.meuusado.entities.Marca;
import com.meuusado.entities.Modelo;

@Repository
public interface ModeloRepository extends JpaRepository<Modelo, Long> {
	
	List<Modelo> findByMarca(Marca marca);

}
