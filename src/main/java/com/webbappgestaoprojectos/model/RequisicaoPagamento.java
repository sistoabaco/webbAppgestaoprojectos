package com.webbappgestaoprojectos.model;

import lombok.*;
import javax.persistence.*;
import java.util.Collection;

@Getter
@Setter
@Builder
@NoArgsConstructor
@AllArgsConstructor

//@Entity
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
    private String vistoCoordenador;
    private String vistoContabilista;
    private String vistoFinanca;
    private String vistoDireccao;

    private String dataPreparadoPor;
    private String dataVistoCoordenador;
    private String dataVistoContabilista;
    private String dataVistoFinanca;
    private String dataVistoDireccao;
    private String status; //rejeitado/aprovado/cancelado/pendente
    private String motivo_rejeicao_cancelamento;

    @OneToMany
    private Collection <FormaPagamento> formaPagamento;
    @OneToOne
    private TermoReferencia termoReferencia;
}
