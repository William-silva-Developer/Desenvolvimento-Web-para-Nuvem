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

import com.br.academico.academico.domain.model.AlunoDiario;
import com.br.academico.academico.domain.repository.AlunoDiarioRepository;
import com.br.academico.academico.domain.service.AlunoDiarioService;

@RestController
@RequestMapping(path = "/api/v1/aluno_diarios", produces = MediaType.APPLICATION_JSON_VALUE)
public class AlunoDiarioController {

    private AlunoDiarioRepository alunoDiarioRepor;
	private AlunoDiarioService alunoDiarioService;
	
	//LISTANDO DIÁRIOS DE ALUNOS
	
	@GetMapping
	public List<AlunoDiario> list(){
		return alunoDiarioService.toList();
	}
	
	//BUSCANDO DIÁRIO DO ALUNO
	
	@GetMapping(path = "/{id}")
	public ResponseEntity<AlunoDiario> search(@PathVariable Long id){
		return alunoDiarioService.toSearch(id)
				.map(c -> ResponseEntity.ok().body(c))
				.orElse(ResponseEntity.noContent().build());
	};
	
	//SALVANDO DIÁRIO DO ALUNO
	
	@PostMapping
	public ResponseEntity<@Valid AlunoDiario> save(@RequestBody AlunoDiario alunoDiario, HttpServletResponse response){
		
		AlunoDiario pessoaServlet = alunoDiarioService.toSave(alunoDiario);
		URI uri = ServletUriComponentsBuilder.fromCurrentServletMapping().path("/{id}")
				.buildAndExpand(pessoaServlet.getId()).toUri();
		response.setHeader("Location", uri.toASCIIString());
		
		return ResponseEntity.created(uri).body(pessoaServlet);
	};
	
	//ATUALIZANDO UM DIÁRIO
	
	@PutMapping(path = "/{id}")
	public ResponseEntity<@Valid AlunoDiario> update(@PathVariable Long id, @Valid @RequestBody AlunoDiario alunoDiario){
		
		if(!alunoDiarioRepor.existsById(id)) {
			return ResponseEntity.notFound().build();
		}
		alunoDiario.setId(id);
		alunoDiario = alunoDiarioService.toSave(alunoDiario);
		return ResponseEntity.ok(alunoDiario);
	};
	
	//DELETANDO UM DIÁRIO
	
	@DeleteMapping(path = "/{id}")
	public ResponseEntity<AlunoDiario> delete(@PathVariable Long id){
		if(alunoDiarioRepor.existsById(id)) {
			return ResponseEntity.notFound().build();
		}
		alunoDiarioService.toDelete(id);
		return ResponseEntity.noContent().build();
	};
    
}
