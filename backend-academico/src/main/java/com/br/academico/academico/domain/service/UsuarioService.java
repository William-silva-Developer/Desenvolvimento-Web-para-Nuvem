package com.br.academico.academico.domain.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.br.academico.academico.domain.model.*;

import com.br.academico.academico.domain.repository.*;

@Service
public class UsuarioService {
	
	@Autowired
	private UsuarioRepository userRepor;
	
	@Transactional
	public List<Usuario> toList(){
		return userRepor.findAll();
	};
	
	@Transactional
	public Usuario toSave (Usuario user) {
		return userRepor.save(user);
	}

}
