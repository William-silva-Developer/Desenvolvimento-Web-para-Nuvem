package com.br.academico.academico.api.resource;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.br.academico.academico.domain.model.Aluno;
import com.br.academico.academico.domain.repository.AlunoRepository;
import com.br.academico.academico.domain.service.AlunoService;

@RestController
@RequestMapping(path = "/api/v1/alunos", produces = MediaType.APPLICATION_JSON_VALUE)
public class AlunoController {

  @Autowired
  private AlunoRepository alunoRepor;
  @Autowired
  private AlunoService alunoService;

    @GetMapping  
     public List<Aluno> list(){
      return alunoService.toList();
    };

    
    
}
