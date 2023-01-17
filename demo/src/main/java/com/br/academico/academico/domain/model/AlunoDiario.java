package com.br.academico.academico.domain.model;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;
import javax.persistence.Table;
import javax.validation.constraints.NotBlank;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;

@Entity
@Table(name = "aluno_diario")
@EqualsAndHashCode
@AllArgsConstructor
@Data
@NoArgsConstructor

public class AlunoDiario {
    @Id
    @EqualsAndHashCode.Include
    @GeneratedValue(strategy = GenerationType.IDENTITY)

    
    @OneToMany(targetEntity = FrequenciaDiario.class, cascade = CascadeType.ALL, mappedBy="aluno_diario", fetch = FetchType.EAGER)
    private Long id;

    @NotBlank
    @OneToOne(fetch = FetchType.EAGER)
    @JoinColumn(name = "matricula_aluno_fk")
    private Aluno aluno;

    @NotBlank
    private Integer nota_b1;

    @NotBlank
    private Integer nota_b2;

    @NotBlank
    @OneToMany(targetEntity = Diario.class, cascade = CascadeType.ALL, mappedBy="aluno_diario", fetch = FetchType.EAGER)
    private Diario diario;
}