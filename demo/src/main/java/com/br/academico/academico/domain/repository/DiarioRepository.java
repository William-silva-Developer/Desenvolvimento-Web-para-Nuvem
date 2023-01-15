package com.br.academico.academico.domain.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.br.academico.academico.domain.model.Diario;

@Repository
public interface DiarioRepository extends JpaRepository<Diario, Long> {
    
}
