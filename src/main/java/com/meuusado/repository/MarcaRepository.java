package com.meuusado.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.meuusado.entities.Marca;

@Repository
public interface MarcaRepository extends JpaRepository<Marca, Long> {

}
