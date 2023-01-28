package com.br.academico.academico.domain.model;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Table;
import javax.validation.constraints.Email;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.Size;
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
    @Size(max = 150)
    private String nome;

    @NotBlank
    @Size(max = 150)
    private String matricula;

    @NotBlank
    @Email(message = "Este email não é válido")
    @Size(max = 100)
    private String email;

    @NotBlank(message = "Informe a senha")
    private String senha;

    @NotBlank(message = "O campo formação deve ser preenchido.")
    @Size(max = 120)
    private String formacao;

    @OneToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "diario_id")
    private Diario diario;


}
