package com.br.academico.academico.domain.repository;

import org.springframework.stereotype.Repository;



import com.br.academico.academico.domain.model.*;


import org.springframework.data.jpa.repository.JpaRepository;


@Repository
public interface UsuarioRepository extends JpaRepository<Usuario, Long> {

	Usuario findByLogin(String login);
	Usuario findBySenha(String senha);	
	

}











