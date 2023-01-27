package com.br.academico.academico.domain.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.br.academico.academico.domain.model.Professor;

@Repository
public interface ProfessorRepository extends JpaRepository<Professor, Long> {
    
}