package com.br.academico.academico.api.resource;

import java.net.URI;
import java.util.List;
import java.util.UUID;
import javax.servlet.http.HttpServletResponse;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import com.br.academico.academico.domain.model.*;
import com.br.academico.academico.domain.repository.*;
import com.br.academico.academico.domain.service.*;

@RestController
@RequestMapping(path = "/api/v1/usuarios", produces = MediaType.APPLICATION_JSON_VALUE)
public class UsuarioController {
	
	@Autowired
	private UsuarioService usuarioService;
	
	@Autowired
	private UsuarioRepository usuarioRepository;
	
	
	@GetMapping
	public List<Usuario> list(){
		return usuarioService.toList();
	}
	
	
	@PostMapping
	public ResponseEntity<Usuario> save(@RequestBody Usuario user, HttpServletResponse response){
		
		Usuario usuarioServlet = usuarioService.toSave(user);
		URI uri = ServletUriComponentsBuilder.fromCurrentServletMapping().path("/{id}")
				.buildAndExpand(usuarioServlet.getCod_usuario()).toUri();
		response.setHeader("Location", uri.toASCIIString());
		
		return ResponseEntity.created(uri).body(usuarioServlet);
	};


	@PutMapping(path = "/{id}")
	public ResponseEntity<Usuario> update(@PathVariable UUID id,  @RequestBody Usuario usuario){
		
		if(!usuarioRepository.existsById(id)) {
			return ResponseEntity.notFound().build();
		}
		usuario.setCod_usuario(id);
		usuario = usuarioService.toSave(usuario);
		return ResponseEntity.ok(usuario);
		
	};

}
