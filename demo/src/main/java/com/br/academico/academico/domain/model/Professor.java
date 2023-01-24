package com.br.academico.academico.domain.model;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Table;
import javax.validation.constraints.Email;
import javax.validation.constraints.NotBlank;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToOne;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;




@Entity
@Table(name = "professor")
@Data
@AllArgsConstructor
@NoArgsConstructor
@EqualsAndHashCode(onlyExplicitlyIncluded = true)
public class Professor {



    @Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@EqualsAndHashCode.Include
    @Column(name = "cod_professor")
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

    @OneToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "cod_diario")
    private Diario diario;


}
