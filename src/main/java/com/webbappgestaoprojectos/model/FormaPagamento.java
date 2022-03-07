package com.webbappgestaoprojectos.model;

import lombok.*;

import javax.persistence.*;

@Getter
@Setter
@Builder
@NoArgsConstructor
@AllArgsConstructor

//@Entity
public class FormaPagamento {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int idFormaPagamento;

    private String beneficiario;
    private String banco;
    private String TipoPagamento;
    private String numeroContaPagamento_NUIT;
    private String numeroContaDoProjecto;

    @ManyToOne
    private FormaPagamento formaPagamento;
}
