package com.br.academico.academico.api.resource;


import java.net.URI;
import javax.servlet.http.HttpSession;
import javax.servlet.http.HttpServletResponse;
import javax.validation.Valid;
import org.springframework.web.bind.annotation.RequestBody;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RestController;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.http.ResponseEntity;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import com.br.academico.academico.domain.model.*;
import com.br.academico.academico.domain.repository.*;
import com.br.academico.academico.domain.service.UsuarioService;


@RestController
@RequestMapping(path = "/api/v1/usuario/login")
public class UsuarioController {
	
	
	@Autowired
	private UsuarioRepository usuariorepository;
	@Autowired
	private UsuarioService usuarioService;

	

	
	
	@GetMapping
	private String login() {
		
		return "/login";
	}
	
	@PostMapping("/api/v1/usuario/{login}/login/{senha}")
	private String Validacao_Login(@RequestParam("login") String login,
			@RequestParam("senha") String senha,
			HttpSession session) {
			
		Usuario user= usuarioService.findByLogin(login, senha);
		
		
		if(user != null) {
			session.setAttribute("usuario", user);
			System.out.println("Entrou!");
			System.out.println("nome:"+user.getNome());
			 
		}else {
			System.out.println("Sem autenticação!");
			
		}
		return "redirect:/";
	}
	
	@GetMapping("/api/v1/usuario/logout")
	public String logout(HttpSession session) {
		session.invalidate();
		
		return "redirect:/login";
	};


	@PostMapping
	public ResponseEntity<Usuario> saveUser(@Valid @RequestBody Usuario usuario, HttpServletResponse response ){

		Usuario pessoaServ = usuarioService.toSave(usuario);
		URI uri = ServletUriComponentsBuilder.fromCurrentServletMapping().path("/{cod_usuario}")
				.buildAndExpand(pessoaServ.getCod_usuario()).toUri();
		response.setHeader("Location", uri.toASCIIString());
		
		return ResponseEntity.created(uri).body(pessoaServ);
		

	}
	


}