package com.webbappgestaoprojectos.model;

import lombok.*;
import javax.persistence.*;

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

    private String orcamentoNr;
    private int pedidoNr;
    private String Nuit;
    private String endereco;
    private String descricaoFornecedor;
    private String email;
    private String fax;
    private String departamento;
    private String formaPagamento;

    private String requisitante;
    private String administracao;
    private String financa;
    private String direccao;

    @OneToOne
    private TermoReferencia termoReferencia;

    @ManyToOne
    private FornecedorTransporte fornecedorTransporte;
}
