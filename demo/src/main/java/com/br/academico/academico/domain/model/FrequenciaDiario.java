package com.br.academico.academico.domain.model;

import java.time.OffsetDateTime;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;
import javax.validation.constraints.NotBlank;


import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;

@Entity
@Table(name = "frequencia_diario")
@EqualsAndHashCode(onlyExplicitlyIncluded = true)
@Data
@AllArgsConstructor
@NoArgsConstructor
public class FrequenciaDiario {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @EqualsAndHashCode.Include
	private Long id;

    @NotBlank
    @ManyToOne(targetEntity = AlunoDiario.class, cascade = CascadeType.ALL, fetch = FetchType.EAGER)
    @JoinColumn(name = "aluno_diario_id")
    private String matriculaAluno;
    
    @NotBlank
    private int numeroFaltas;

    @NotBlank
    private OffsetDateTime date;
    
}
