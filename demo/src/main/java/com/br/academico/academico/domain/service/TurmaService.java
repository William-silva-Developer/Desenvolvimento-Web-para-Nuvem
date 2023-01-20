package com.br.academico.academico.domain.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.br.academico.academico.domain.model.Turma;
import com.br.academico.academico.domain.repository.TurmaRepository;

import lombok.AllArgsConstructor;

@Service
@AllArgsConstructor
public class TurmaService {
	
    private TurmaRepository turmaRepor;
	
	@Transactional
	public List<Turma> toList(){
		return turmaRepor.findAll();
	};
	
	@Transactional
	public Optional<Turma> toSearch(Long id){
		return turmaRepor.findById(id);
	};
	
	@Transactional
	public Turma toSave(Turma turma) {
		return turmaRepor.save(turma);
	};
	
	@Transactional
	public void toDelete(Long id) {
		turmaRepor.deleteById(id);
	};
    
}
