package com.br.academico.academico.domain.service;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import lombok.AllArgsConstructor;



import com.br.academico.academico.domain.model.*;
import com.br.academico.academico.domain.repository.*;

@Service
@AllArgsConstructor
public class UsuarioService {

    private UsuarioRepository usuarioRepor;

    @Transactional
    public Usuario findByLogin(String login, String senha) {
        
        Usuario usuario = new Usuario();
        usuario.setLogin(login);
        usuario.setSenha(senha);
        if(usuario.equals(usuarioRepor.findByLogin(login)) & usuario.equals(usuarioRepor.findBySenha(senha))){

            return usuario;

        }else{}

       return null;
		
	};
    @Transactional
    public Usuario toSave(Usuario usuario){

        return usuarioRepor.save(usuario);

    };
    
}
