package com.br.academico.academico.domain.model;

import javax.persistence.Entity;

import javax.persistence.Table;
import javax.validation.constraints.Email;
import javax.validation.constraints.NotBlank;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;


@Data
@AllArgsConstructor
@NoArgsConstructor
@Entity
@Table(name = "professor")
@EqualsAndHashCode(onlyExplicitlyIncluded = true)

public class Professor {

    @Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@EqualsAndHashCode.Include
	private Long id;

    @NotBlank
    private String nome;

    @NotBlank
    private String matricula;

    @NotBlank
    @Email(message = "Este email não é válido")
    private String email;

    @NotBlank
    private String senha;

    @NotBlank
    private String formacao;


}
