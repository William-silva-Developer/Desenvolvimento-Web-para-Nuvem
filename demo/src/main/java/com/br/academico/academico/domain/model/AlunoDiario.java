package com.br.academico.academico.domain.model;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
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
    private Long id;
    @NotBlank
    @ManyToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "aluno_matricula")
    private Aluno aluno;
    private Integer nota_b1;
    private Integer nota_b2;
    @OneToMany(cascade = CascadeType.ALL, mappedBy="diario")
    private Diario diario;
}