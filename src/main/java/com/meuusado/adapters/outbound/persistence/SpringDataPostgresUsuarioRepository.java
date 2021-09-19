package com.meuusado.adapters.outbound.persistence;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.meuusado.adapters.outbound.persistence.entity.UsuarioEntity;
import com.meuusado.application.domain.Usuario;

@Repository
public interface SpringDataPostgresUsuarioRepository extends JpaRepository<UsuarioEntity, Long> {

	Usuario findByEmail(String email);
	
}
