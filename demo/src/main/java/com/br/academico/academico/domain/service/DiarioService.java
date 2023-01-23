package com.br.academico.academico.domain.service;

import java.util.List;
import java.util.Optional;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.br.academico.academico.domain.model.Diario;
import com.br.academico.academico.domain.repository.DiarioRepository;



@Service
public class DiarioService {
    private DiarioRepository diarioRepor;

    @Transactional
    public List<Diario> toList(){
        return diarioRepor.findAll();
    };

    @Transactional
    public Optional<Diario> toSearch( Long id){
        return diarioRepor.findById(id);
    };

    @Transactional
    public Diario toSave(Diario diario){
        return diarioRepor.save(diario);
    };

    @Transactional
    public void toDelete(Long id){
        diarioRepor.deleteById(id);
    };
    
}