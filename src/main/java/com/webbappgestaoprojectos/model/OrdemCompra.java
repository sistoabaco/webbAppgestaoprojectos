package com.webbappgestaoprojectos.model;

import lombok.*;
import javax.persistence.*;
import java.time.LocalDate;

@Getter
@Setter
@Builder
@NoArgsConstructor
@AllArgsConstructor

@Entity
public class OrdemCompra {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int idOrdemCompra;

    private String nomeProjecto;
    private String mes;
    private LocalDate data;

    private String orcamentoNr;
    private int pedidoNr;
    private String departamento;
    private String formaPagamento;
    private String condicaoPagamento;
    private String previsaoEntrega;
    private String observacao;
    private double valorTotal;

    private String requisitante;
    private String administracao;
    private String financa;
    private String direccao;

    @OneToOne
    private TermoReferencia termoReferencia;

    @OneToOne
    private FornecedorTransporte fornecedorTransporte;
}
