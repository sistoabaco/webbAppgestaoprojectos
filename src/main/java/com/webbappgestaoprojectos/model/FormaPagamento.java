package com.webbappgestaoprojectos.model;

import lombok.*;
import javax.persistence.*;

@Getter
@Setter
@Builder
@NoArgsConstructor
@AllArgsConstructor

@Entity
public class FormaPagamento {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int idFormaPagamento;

    private String banco;
    private String TipoPagamento;
    private String numeroCheque;
    private String caixa;
    private String numeroContaDoProjecto;

    @OneToOne
    private RequisicaoPagamento requisicaoPagamento;

    @OneToOne
    private FornecedorTransporte fornecedorTransporte;
}
