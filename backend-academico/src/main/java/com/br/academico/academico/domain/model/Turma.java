package com.br.academico.academico.domain.model;


import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.Size;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;



@Entity
@Table(name = "turma")
@EqualsAndHashCode(onlyExplicitlyIncluded = true)
@Data
@AllArgsConstructor
@NoArgsConstructor
public class Turma  {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @EqualsAndHashCode.Include
    @Column(name = "cod_turma")
    private Long id;

    @NotBlank(message = "O campo periodo dever ser preenchido.")
    @Size(max = 10)
    private String periodo;
    
    @NotBlank(message = "O campo ano civil deve ser preenchido.")
    @Column(name = "ano_civil")
    @Size(max = 6)
    private String anoCivil;
    
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "turma")
    private List<Diario> diarios;
}
