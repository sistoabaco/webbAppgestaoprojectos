package com.webbappgestaoprojectos.model;

import lombok.*;
import javax.persistence.*;
import java.io.Serializable;
import java.util.Collection;

@Getter
@Setter
@Builder
@NoArgsConstructor
@AllArgsConstructor

@Entity
public class SolicitacaoTransporte implements Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int idSolicitacaoTransporte;

    private String tipoDeViatura;
    private int qtdViaturas;
    private String solitanteResponsavel;
    private String acompanhante;
    private String origem;
    private String destino;
    private String dataInicio;
    private String dataFim;
    private boolean necessidadeAlojamento;
    private int qtdDias;
    private int qtdPessoas;
    private boolean motivoDaSolicitacao;
    private String vistoCoordenador;
    private String vistoLogistico;
    private String dataAprovacaoCoordenador;
    private String dataAprovacaoLogistico;

    private String status; //rejeitado/aprovado/cancelado/pendente
    private String motivo_rejeicao_cancelamento;

    @ManyToOne(cascade = CascadeType.ALL)
    private Projecto projecto;

    @ManyToOne(cascade = CascadeType.ALL)
    private Funcionario funcionario;
}
