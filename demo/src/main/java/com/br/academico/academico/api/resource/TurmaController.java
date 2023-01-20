package com.br.academico.academico.api.resource;

import java.net.URI;
import java.util.List;

import javax.servlet.http.HttpServletResponse;
import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import com.br.academico.academico.domain.model.Turma;
import com.br.academico.academico.domain.repository.TurmaRepository;
import com.br.academico.academico.domain.service.TurmaService;

import lombok.AllArgsConstructor;



@RestController
@AllArgsConstructor

@RequestMapping(path = "/api/v1/turmas", produces = MediaType.APPLICATION_JSON_VALUE)
public class TurmaController {

	private TurmaRepository turmaRepor;

	private TurmaService turmaService;
	
	
	//LISTAR TURMAS
	
	@GetMapping
	public List<Turma> list(){
		return turmaService.toList();
	};
	
	//BUSCAR TURMA POR ID
	
	@GetMapping(path = "/{id}")
	public ResponseEntity<Turma> search(@PathVariable Long id){
		return turmaService.toSearch(id)
				.map(ResponseEntity::ok)
				.orElse(ResponseEntity.noContent().build());
	};
	
	//SALVAR TURMA
	
	@PostMapping
	public ResponseEntity<@Valid Turma> save(@Valid @RequestBody Turma turma, HttpServletResponse response ){
		
		Turma pessoaServ = turmaService.toSave(turma);
		URI uri = ServletUriComponentsBuilder.fromCurrentServletMapping().path("/{id}")
				.buildAndExpand(pessoaServ.getId()).toUri();
		response.setHeader("Location", uri.toASCIIString());
		
		return ResponseEntity.created(uri).body(pessoaServ);
	};
	
	//ATUALIZAR 
	
	@PutMapping(path = "/{id}")
	public ResponseEntity<Turma> update(@PathVariable Long id, @Valid @RequestBody Turma turma){
		
		if(!turmaRepor.existsById(id)) {
			return ResponseEntity.notFound().build();
		}
		turma.setId(id);
		turma = turmaService.toSave(turma);
		return ResponseEntity.ok(turma);
		
	};
	
	
	@DeleteMapping(path = "/{id}")
	public ResponseEntity<Turma> delete(@PathVariable Long id){
		
		if(!turmaRepor.existsById(id)) {
			return ResponseEntity.notFound().build();
		}
		turmaService.toDelete(id);
		return ResponseEntity.noContent().build();
		
	};
    
}