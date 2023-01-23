package com.br.academico.academico.domain.model;


import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
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
    private Long id;

    @NotBlank
    private Aluno aluno; 

    @NotBlank
    @JoinColumn(name = "Bimestre-01")
    private Integer notaBimestre1;

    @NotBlank
    @JoinColumn(name = "Bimestre-02")
    private Integer notaBimestre2;

/*     @NotBlank
    @OneToMany(targetEntity = Diario.class, cascade = CascadeType.ALL, mappedBy="aluno_diario", fetch = FetchType.EAGER)
    */
    private Diario diario;
    
}