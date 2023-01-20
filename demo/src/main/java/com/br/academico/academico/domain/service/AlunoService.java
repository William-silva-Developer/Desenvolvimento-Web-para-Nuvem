package com.br.academico.academico.domain.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.br.academico.academico.domain.model.Aluno;
import com.br.academico.academico.domain.repository.AlunoRepository;



@Service
public class AlunoService {
    
    @Autowired
    private AlunoRepository alunoRepor;

    @Transactional
    public List<Aluno> toList(){
        return alunoRepor.findAll();
    };

    @Transactional
    public Optional<Aluno> toSearch(Long id){
        return alunoRepor.findById(id);
    };

    @Transactional
    public Aluno toSave(Aluno aluno){
        return alunoRepor.save(aluno);
    };

    @Transactional
    public void toDelete(Long id){
        alunoRepor.deleteById(id);
    }
    
}
