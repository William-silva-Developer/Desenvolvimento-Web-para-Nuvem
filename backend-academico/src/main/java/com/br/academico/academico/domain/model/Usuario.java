package com.br.academico.academico.domain.model;

import java.util.Collection;


import javax.persistence.Embedded;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.Size;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;





@Entity
@Table(name = "usuario")
@Data
@AllArgsConstructor
@NoArgsConstructor
@EqualsAndHashCode(onlyExplicitlyIncluded = true)
public class Usuario{
    
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @EqualsAndHashCode.Include
    private Long cod_usuario;
    
    @NotBlank(message = "O campo login deve ser preenchido")
    private String login;


    @NotBlank(message = "O campo nome deve ser preenchido")
    @Size(min = 3, max = 100)
    private String nome;
    
    @NotBlank(message = "O campo matricula deve ser preenchido")
    @Size(min = 4, max = 20)
    private String matricula;

    @NotBlank(message = "Digite uma senha")
    @Size(min = 4, max = 8)
    private String senha;
    
    @Embedded
    @NotBlank(message = "O campo perfil deve ser preenchido")
    private Perfil perfil;



    public String getLogin() {
        return login;
    }

    public void setLogin(String login) {
        this.login = login;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public String getMatricula() {
        return matricula;
    }

    public void setMatricula(String matricula) {
        this.matricula = matricula;
    }

    public String getSenha() {
        return senha;
    }

    public void setSenha(String senha) {
        this.senha = senha;
    }

    public Perfil getPerfil() {
        return perfil;
    }

    public void setPerfil(Perfil perfil) {
        this.perfil = perfil;
    }


   

    
}
