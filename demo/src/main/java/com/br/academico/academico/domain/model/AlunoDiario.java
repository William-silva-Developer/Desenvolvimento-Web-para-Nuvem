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
@EqualsAndHashCode(onlyExplicitlyIncluded = true)
@AllArgsConstructor
@Data
@NoArgsConstructor
public class AlunoDiario {
    @Id
    @EqualsAndHashCode.Include
    @GeneratedValue(strategy = GenerationType.IDENTITY)

    @OneToMany(targetEntity = FrequenciaDiario.class, cascade = CascadeType.ALL, mappedBy = "aluno_diario", fetch = FetchType.LAZY)
    private Long id;

    @OneToOne(fetch = FetchType.EAGER)
    @JoinColumn(name = "matricula_aluno_fk")
    private Aluno aluno;

    @NotBlank
    private int notaBimestre1;

    @NotBlank
    private int notaBimestre2;

    @NotBlank
    @OneToMany(targetEntity = Diario.class, cascade = CascadeType.ALL, mappedBy="aluno_diario", fetch = FetchType.LAZY)
    private Diario diario;
}