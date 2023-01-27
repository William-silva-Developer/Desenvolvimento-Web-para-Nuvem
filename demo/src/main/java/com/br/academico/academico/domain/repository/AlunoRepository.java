package com.br.academico.academico.domain.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.br.academico.academico.domain.model.Aluno;

@Repository
public interface AlunoRepository extends JpaRepository<Aluno, Long> {
    
}