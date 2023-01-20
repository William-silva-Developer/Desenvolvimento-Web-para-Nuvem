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

import com.br.academico.academico.domain.model.FrequenciaDiario;
import com.br.academico.academico.domain.repository.FrequenciaDiarioRepository;
import com.br.academico.academico.domain.service.FrenquenciaDiarioService;

import lombok.AllArgsConstructor;



@RestController
@AllArgsConstructor

@RequestMapping(path = "/api/v1/frequencia_diarios", produces = MediaType.APPLICATION_JSON_VALUE)
public class FrequenciaDiarioController {

    private FrequenciaDiarioRepository frequenciaRepor;

	private FrenquenciaDiarioService frequenciaService;
    

    //LISTAR TURMAS
	
	@GetMapping
	public List<FrequenciaDiario> list(){
		return frequenciaService.toList();
	};
	
	//BUSCAR TURMA POR ID
	
	@GetMapping(path = "/{id}")
	public ResponseEntity<FrequenciaDiario> search(@PathVariable Long id){
		return frequenciaService.toSearch(id)
				.map(ResponseEntity::ok)
				.orElse(ResponseEntity.noContent().build());
	};
	
	//SALVAR TURMA
	
	@PostMapping
	public ResponseEntity<@Valid FrequenciaDiario> save(@Valid @RequestBody FrequenciaDiario frequencia, HttpServletResponse response ){
		
		FrequenciaDiario pessoaServ = frequenciaService.toSave(frequencia);
		URI uri = ServletUriComponentsBuilder.fromCurrentServletMapping().path("/{id}")
				.buildAndExpand(pessoaServ.getId()).toUri();
		response.setHeader("Location", uri.toASCIIString());
		
		return ResponseEntity.created(uri).body(pessoaServ);
	};
	
	//ATUALIZAR 
	
	@PutMapping(path = "/{id}")
	public ResponseEntity<FrequenciaDiario> update(@PathVariable Long id, @Valid @RequestBody FrequenciaDiario frequencia){
		
		if(!frequenciaRepor.existsById(id)) {
			return ResponseEntity.notFound().build();
		}
		frequencia.setId(id);
		frequencia = frequenciaService.toSave(frequencia);
		return ResponseEntity.ok(frequencia);
		
	};
	
	
	@DeleteMapping(path = "/{id}")
	public ResponseEntity<FrequenciaDiario> delete(@PathVariable Long id){
		
		if(!frequenciaRepor.existsById(id)) {
			return ResponseEntity.notFound().build();
		}
		frequenciaService.toDelete(id);
		return ResponseEntity.noContent().build();
		
	};
}