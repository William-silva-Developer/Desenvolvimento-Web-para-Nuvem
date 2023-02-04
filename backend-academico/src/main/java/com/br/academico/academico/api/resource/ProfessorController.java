package com.br.academico.academico.api.resource;

import java.net.URI;
import java.util.List;

import javax.servlet.http.HttpServletResponse;
import javax.validation.Valid;



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

import com.br.academico.academico.domain.model.Professor;
import com.br.academico.academico.domain.repository.ProfessorRepository;
import com.br.academico.academico.domain.service.ProfessorService;

import io.swagger.annotations.ApiResponse;
import io.swagger.annotations.ApiResponses;
import lombok.AllArgsConstructor;




@RestController
@RequestMapping(path = "/api/v1/professores")
@AllArgsConstructor
public class ProfessorController {
	
    private ProfessorRepository professorRepor;
	
	private ProfessorService professorService;


	@ApiResponses(value = {
		@ApiResponse(code = 200, message = "Sucesso"),
		@ApiResponse(code = 201, message = "Foi criado um objeto"),
		@ApiResponse(code = 403, message = "Você não tem permissão para acessar este recurso"),
		@ApiResponse(code = 500, message = "Foi gerada uma exception")
	})
	
	//LISTAR
	
	@GetMapping
	public List<Professor> list(){
		return professorService.toList();
	};
	
	//BUSCANDO PROFESSOR POR ID
	
	@GetMapping(path = "/{id}")
	public ResponseEntity<Professor> search(@PathVariable Long id){
		return professorService.toSearch(id)
				.map(c -> ResponseEntity.ok().body(c))
				.orElse(ResponseEntity.noContent().build());
	};
	
	//SALVANDO PROFESSOR
	
	@PostMapping
	public ResponseEntity<@Valid Professor> save(@Valid @RequestBody Professor professor, HttpServletResponse response){
			
			Professor professorServl = professorService.toSave(professor);
			URI uri = ServletUriComponentsBuilder.fromCurrentServletMapping().path("/{codigo}")
					.buildAndExpand(professorServl.getId()).toUri();
			response.setHeader("Location", uri.toASCIIString());
			
			return ResponseEntity.created(uri).body(professorServl);
		};
		
		//ATUALIZANDO PROFESSOR
		
		@PutMapping(path = "/{id}")
		public ResponseEntity<@Valid Professor> update(@PathVariable Long id, @Valid @RequestBody Professor professor){
			
			if(!professorRepor.existsById(id)) {
				return ResponseEntity.notFound().build();
			}
			
			professor.setId(id);
			professor = professorService.toSave(professor);
			return ResponseEntity.ok(professor);
		};
		
		//DELETANDO UM PROFESSOR
		
		@DeleteMapping(path = "/{id}")
		public ResponseEntity<Professor> delete(@PathVariable Long id){
			
			if(!professorRepor.existsById(id)) {
				return ResponseEntity.notFound().build();
			}
			professorService.toDelete(id);
			return ResponseEntity.noContent().build();
		};
    
}
