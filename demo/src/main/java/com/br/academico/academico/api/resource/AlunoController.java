package com.br.academico.academico.api.resource;

import java.net.URI;
import java.util.List;

import javax.servlet.http.HttpServletResponse;
import javax.validation.Valid;


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

import com.br.academico.academico.domain.model.Aluno;
import com.br.academico.academico.domain.repository.AlunoRepository;
import com.br.academico.academico.domain.service.AlunoService;

import lombok.RequiredArgsConstructor;








@RequestMapping(path = "/api/v1/alunos", produces = MediaType.APPLICATION_JSON_VALUE)
@RequiredArgsConstructor
@RestController
public class AlunoController {

  
  private AlunoRepository alunoRepor;
  
  
  private AlunoService alunoService;

    @GetMapping  
     public List<Aluno> list(){
      return alunoService.toList();
    };

    // BUSCAR POR ID
	
	@GetMapping(path = "/{id}")
	public ResponseEntity<Aluno> search( @PathVariable Long id ){
		return alunoService.toSearch(id)
				.map(aluno -> ResponseEntity.ok().body(aluno))
				.orElse(ResponseEntity.noContent().build());
	};
	
	
	// SALVAR UM ALUNO
	
	@PostMapping
	public ResponseEntity<@Valid Aluno> save(@Valid @RequestBody Aluno aluno, HttpServletResponse response){
		
		Aluno pessoaServl = alunoService.toSave(aluno);
		URI uri = ServletUriComponentsBuilder.fromCurrentServletMapping().path("/{codigo}")
				.buildAndExpand(pessoaServl.getId()).toUri();
		response.setHeader("Location", uri.toASCIIString());
		
		return ResponseEntity.created(uri).body(pessoaServl);
	};
	
	//ATUALIZAR UM ALUNO
	
	@PutMapping(path = "/{id}")
	public ResponseEntity<@Valid Aluno> update(@PathVariable Long id, @Valid @RequestBody Aluno aluno){
		
		if(!alunoRepor.existsById(id)) {
			return ResponseEntity.notFound().build();
		}
		aluno.setId(id);
		aluno = alunoService.toSave(aluno);
		return ResponseEntity.ok(aluno);
		
	};
	
	//DELETAR UM ALUNO
	
	@DeleteMapping(path = "/{id}")
	public ResponseEntity<@Valid Aluno> delete( @PathVariable Long id){
		
		if(!alunoRepor.existsById(id)) {
			return ResponseEntity.notFound().build();
		}
		alunoService.toDelete(id);
		return ResponseEntity.noContent().build();
	}



    
}
