package com.br.academico.academico.domain.service;

import java.util.List;
import java.util.Optional;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.br.academico.academico.domain.model.Professor;
import com.br.academico.academico.domain.repository.ProfessorRepository;

import lombok.AllArgsConstructor;




@Service
@AllArgsConstructor

public class ProfessorService {
    private ProfessorRepository professorRepor;
	
	@Transactional
	public List<Professor> toList(){
		return professorRepor.findAll();
	};
	
	@Transactional
	public Optional<Professor> toSearch(Long id){
		return professorRepor.findById(id);
	};
	
	@Transactional
	public Professor toSave(Professor professor) {
		return professorRepor.save(professor);
	};
	
	@Transactional
	public void toDelete(Long id) {
		 professorRepor.deleteById(id);
	}
    
}
