package com.br.academico.academico.domain.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.validation.constraints.Email;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.Size;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;


@Entity
@Table(name = "aluno")
@EqualsAndHashCode(onlyExplicitlyIncluded = true)
@Data
@AllArgsConstructor
@NoArgsConstructor
public class Aluno {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@EqualsAndHashCode.Include
	@Column(name = "cod_aluno")
	private Long id;
	
	@NotBlank
	private String matricula;

	@NotBlank
	@Size(max = 150)
	private String nome;
	
	@NotBlank
	@Email(message = "Este email não é válido")
	private String email;

	
	@NotBlank(message = "Senha do Aluno deve ser preenchida")
    @Size(min = 6, max = 10, message = "Senha do aluno deve ter entre 6 e 20 caracteres")
	private String senha;

	
	

}
