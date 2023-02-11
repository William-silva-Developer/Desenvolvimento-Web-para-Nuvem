package com.br.academico.academico.security;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.br.academico.academico.domain.repository.*;
import com.br.academico.academico.domain.model.*;



@Service
@Transactional
public class UsuarioDetailsServiceImpl implements UserDetailsService {
	
	@Autowired
	private UsuarioRepository usuarioRepor;
	
	

	@Override
	public UserDetails loadUserByUsername(String nome) throws UsernameNotFoundException {
		Usuario usuario = usuarioRepor.findByNome(nome)
				.orElseThrow(() -> new  UsernameNotFoundException(nome + "Usuário não encontrado na base de dados"));
		System.out.println(nome);
		
		return new User(usuario.getUsername(), usuario.getPassword(), true, true, true, true, usuario.getAuthorities());
	}

	
}