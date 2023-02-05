package com.br.academico.academico.domain.model;

import javax.persistence.Embeddable;

import lombok.Getter;
import lombok.Setter;




@Embeddable
@Getter
@Setter
public class Perfil {
    
    private String professor;
    private String aluno;
    private String admin;
    
}
