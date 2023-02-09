package com.br.academico.academico.domain.model;

import java.time.OffsetDateTime;


import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.Size;

import com.fasterxml.jackson.annotation.JsonFormat;

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
    @Column(name = "cod_frequencia")
	private Long id;
 
    @NotBlank
    @ManyToOne(targetEntity = AlunoDiario.class, cascade = CascadeType.ALL, fetch = FetchType.EAGER)
    @JoinColumn(name = "aluno_diario_id")
    private AlunoDiario alunoDiario;
    
    

    @NotBlank(message = "A matricula não poder ser nula.")
    @Column(name = "matricula_aluno")
    private String matriculaAluno;
    
    @NotBlank
    @Column(name = "numero_falta")
    @Size(min = 3, max = 100)
    private Integer numeroFaltas;

    @NotBlank
    @JsonFormat(pattern = "YYYY/MM/DD")
    private OffsetDateTime date;
    
 /*    @ManyToOne(cascade = CascadeType.ALL)
    private List<AlunoDiario> alunoDiario;
    */
}