package com.br.academico.academico.domain.service;

import java.util.List;
import java.util.Optional;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.br.academico.academico.domain.model.FrequenciaDiario;
import com.br.academico.academico.domain.repository.FrequenciaDiarioRepository;

import lombok.AllArgsConstructor;


@Service
@AllArgsConstructor

public class FrenquenciaDiarioService {
    private FrequenciaDiarioRepository frequenciaRepor;

    @Transactional
    public List<FrequenciaDiario> toList(){
        return frequenciaRepor.findAll();
    };

    @Transactional
    public Optional<FrequenciaDiario> toSearch( Long id){
        return frequenciaRepor.findById(id);
    };

    @Transactional
    public FrequenciaDiario toSave(FrequenciaDiario frequencia){
        return frequenciaRepor.save(frequencia);
    };

    @Transactional
    public void toDelete(Long id){
        frequenciaRepor.deleteById(id);
    };
    
}
