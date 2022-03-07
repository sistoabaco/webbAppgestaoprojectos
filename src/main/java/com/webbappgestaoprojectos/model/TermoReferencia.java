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
public class TermoReferencia implements Serializable {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int idTermoReferencia;

    private String coordenador;
    private String localDataDaActividade;
    private String participantes;
    private String beneficiario;
    private String descricaoActividade;
    private String objectivoActividade;
    private double saldoTotalActividade;
    private String elaboradoPor;
    private String aprovadoPor;

    private String status; //rejeitado/aprovado/cancelado/pendente
    private String motivo_rejeicao_cancelamento;

    @ManyToMany()
    @JoinTable(
            name = "projecto_tdr",
            joinColumns = @JoinColumn(
                    name = "idTermoReferencia", referencedColumnName = "idTermoReferencia"),
            inverseJoinColumns = @JoinColumn(
                    name = "idProjecto", referencedColumnName = "idProjecto"))
    private Collection <Projecto> projecto;

    @OneToOne
    private SolicitacaoTransporte solicitacaoTransporte;

    @OneToMany
    private Collection <TabelaNecessidadeTdR> necessidadeTdR;

    @ManyToOne (cascade = CascadeType.ALL)
    private Funcionario funcionario;
}