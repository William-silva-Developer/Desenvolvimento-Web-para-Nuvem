package com.br.academico.academico.domain.model;


import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToOne;
import javax.persistence.Table;
import javax.validation.constraints.NotBlank;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;

@Entity
@Table(name = "diario")
@EqualsAndHashCode(onlyExplicitlyIncluded = true)
@Data
@AllArgsConstructor
@NoArgsConstructor
public class Diario {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
	@EqualsAndHashCode.Include

    @ManyToOne(targetEntity = Turma.class, cascade = CascadeType.ALL, fetch = FetchType.EAGER)
    @JoinColumn(name = "diario_id")
	private Long id;

    @NotBlank
    @ManyToOne(targetEntity = AlunoDiario.class, cascade = CascadeType.ALL, fetch = FetchType.EAGER)
    @JoinColumn(name = "aluno_diario_fk")
    private String disciplina;

    @NotBlank
    private int cargaHoraria;
 
    @NotBlank
    @OneToOne(fetch = FetchType.EAGER)
    @JoinColumn(name = "professor_id")
    private Professor professor;
    
}
