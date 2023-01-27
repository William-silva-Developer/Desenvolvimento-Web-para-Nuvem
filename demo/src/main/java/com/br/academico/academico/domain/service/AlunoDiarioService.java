package com.br.academico.academico.domain.service;

import java.util.List;
import java.util.Optional;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.br.academico.academico.domain.model.AlunoDiario;
import com.br.academico.academico.domain.repository.AlunoDiarioRepository;

import lombok.RequiredArgsConstructor;

@Service
@RequiredArgsConstructor
public class AlunoDiarioService {
	
	private AlunoDiarioRepository alunoDiarioRepor;
	
	@Transactional
	public List<AlunoDiario> toList(){
		return alunoDiarioRepor.findAll();
	};
	
	
	@Transactional
	public Optional<AlunoDiario> toSearch(Long id){
		return alunoDiarioRepor.findById(id);
	};
	
	@Transactional
	public AlunoDiario toSave(AlunoDiario alunoDiario) {
		return alunoDiarioRepor.save(alunoDiario);
	};
	
	@Transactional
	public void toDelete(Long id) {
		alunoDiarioRepor.deleteById(id);
	};

}
