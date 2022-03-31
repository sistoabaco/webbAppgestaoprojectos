package com.webbappgestaoprojectos.model;

import lombok.*;
import javax.persistence.*;
import java.time.LocalDate;
import java.util.Collection;

@Getter
@Setter
@Builder
@NoArgsConstructor
@AllArgsConstructor

@Entity
public class RequisicaoPagamento {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int idRequisicaoPagamento;

    private String localizacao;
    private String requisitante;
    private String data;
    private String tipoMoeda;
    private String cotacao_proforma_adiantamento_nr;
    private String valorPorExtenso;

    private String preparadoPor;
    private LocalDate dataPreparadoPor;

    private String vistoCoordenador;
    private LocalDate dataVistoCoordenador;

    private String vistoContabilista;
    private LocalDate dataVistoContabilista;

    private String vistoFinanca;
    private LocalDate dataVistoFinanca;

    private String vistoDireccao;
    private LocalDate dataVistoDireccao;

    private String status; //rejeitado/aprovado/cancelado/pendente
    private String motivo_rejeicao_cancelamento;

    @OneToMany
    private Collection <FormaPagamento> formaPagamento;

    @OneToOne
    private TermoReferencia termoReferencia;
}
