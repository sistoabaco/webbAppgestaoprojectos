package com.webbappgestaoprojectos.model;

import lombok.*;
import org.springframework.format.annotation.DateTimeFormat;
import javax.persistence.*;
import java.io.Serializable;
import java.time.LocalDate;
import java.util.Date;

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
    private String solicitanteResponsavel;
    private String acompanhante;
    private String origem;
    private String destino;

    @DateTimeFormat(pattern = "yyyy-mm-dd")
    private Date dataInicio;
    @DateTimeFormat(pattern = "yyyy-mm-dd")
    private Date dataFim;

    private String necessidadeAlojamento;
    private int qtdDias;
    private int qtdPessoas;
    private String motivoDaSolicitacao;

    private String coordenador;
    @DateTimeFormat(pattern = "yyyy-mm-dd")
    private LocalDate dataAprovacaoCoordenador;

    private String logistico;
    @DateTimeFormat(pattern = "yyyy-mm-dd")
    private LocalDate dataAprovacaoLogistico;

    private String status; //rejeitado/aprovado/cancelado/pendente
    private String motivo_rejeicao_cancelamento;

    @ManyToOne
    private Projecto projecto;

    @ManyToOne
    private Funcionario funcionario;
}