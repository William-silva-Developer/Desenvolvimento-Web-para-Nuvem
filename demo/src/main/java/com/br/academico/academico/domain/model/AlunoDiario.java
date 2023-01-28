package com.br.academico.academico.domain.model;



import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
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
@Data
@AllArgsConstructor
@NoArgsConstructor
public class AlunoDiario {
    @Id
    @EqualsAndHashCode.Include
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "cod_aluno_diario")
    private Long id;
  
    @NotBlank
    @Column(name = "Bimestre_01")
    private Integer notaBimestre1;

    @NotBlank
    @Column(name = "Bimestre_02")
    private Integer notaBimestre2;

/*     @NotBlank
    @OneToMany(targetEntity = Diario.class, cascade = CascadeType.ALL, mappedBy="aluno_diario", fetch = FetchType.EAGER)
    private Diario diario;
    */
    @NotBlank
    @OneToOne
    @JoinColumn(name = "aluno_id", referencedColumnName = "cod_aluno")
    private Aluno aluno; 

}