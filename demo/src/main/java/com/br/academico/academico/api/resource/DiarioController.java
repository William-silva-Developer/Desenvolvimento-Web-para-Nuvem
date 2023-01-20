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

import com.br.academico.academico.domain.model.Diario;
import com.br.academico.academico.domain.repository.DiarioRepository;
import com.br.academico.academico.domain.service.DiarioService;

import lombok.AllArgsConstructor;

@RestController
@RequestMapping(path = "/api/v1/diarios", produces = MediaType.APPLICATION_JSON_VALUE)
@AllArgsConstructor
public class DiarioController {


    private DiarioRepository diarioRepor;
	
    private DiarioService diarioService;

    //LISTAR DIARIOS
	
	@GetMapping
	public List<Diario> list(){
		return diarioService.toList();
	};
	
	//BUSCAR DIARIO POR AD
	
	@GetMapping(path = "/{id}")
	public ResponseEntity<Diario> search(@PathVariable Long id){
		return diarioService.toSearch(id)
				.map(c -> ResponseEntity.ok().body(c))
				.orElse(ResponseEntity.noContent().build());
	};
	
	//SALVANDO UM DIARIO
	
	@PostMapping
	public ResponseEntity<@Valid Diario> save( @Valid @RequestBody Diario diario, HttpServletResponse response ){
		
		Diario diarioServ = diarioService.toSave(diario);
		URI uri = ServletUriComponentsBuilder.fromCurrentServletMapping().path("/{id}")
				.buildAndExpand(diarioServ.getId()).toUri();
		response.setHeader("Location", uri.toASCIIString());
		
		return ResponseEntity.created(uri).body(diarioServ);
	};
	
	
	//ATUALIZANDO DIÁRIO
	
	@PutMapping(path = "/{id}")
	public ResponseEntity<Diario> update( @PathVariable Long id, @Valid @RequestBody Diario diario){
		
		if(!diarioRepor.existsById(id)) {
			return ResponseEntity.notFound().build();
		}
		
		diario.setId(id);
		diario = diarioService.toSave(diario);
		return ResponseEntity.ok(diario);
	};
	
	//DELETANDO DIÁRIO
	
	@DeleteMapping(path = "/{id}")
	public ResponseEntity<Diario> delete(@PathVariable Long id){
		
		if(!diarioRepor.existsById(id)) {
			
			return ResponseEntity.notFound().build();
		}
		diarioService.toDelete(id);
		return ResponseEntity.noContent().build();
	};
	
    
}
