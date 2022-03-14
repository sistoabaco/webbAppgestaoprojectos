package com.webbappgestaoprojectos.model;

import lombok.*;
import javax.persistence.*;
import java.io.Serializable;

@Getter
@Setter
@Builder
@NoArgsConstructor
@AllArgsConstructor

@Entity
public class TabelaNecessidadeTdR implements Serializable {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int idTabelaNecessidade;

    private int ordem;
    private String descricaoMaterial;
    private double valorUnitario;
    private int qtdMaterial;
    private int qtdDias;
    private double valorTotal;
    private String codigo;

    @ManyToOne(cascade = CascadeType.ALL)
    private TermoReferencia termoReferencia;
}