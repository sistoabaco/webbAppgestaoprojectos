package com.webbappgestaoprojectos.model;

import lombok.*;
import javax.persistence.*;
import java.io.Serializable;
import java.time.LocalDate;
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
    private String localEDataDaActividade;
    private String participantes;
    private String beneficiario;
    private String descricaoActividade;
    private String objectivoActividade;
    private double saldoTotalActividade = 0;

    private String elaboradoPor;
    private LocalDate dataElaboracao;

    private String AprovadoPor;
    private LocalDate DataAprovacao;

    private String status; //rejeitado/aprovado/cancelado/pendente
    private String motivo_rejeicao_cancelamento;

    @ManyToMany(cascade = CascadeType.ALL)
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

    @Override
    public String toString(){
        return getLocalEDataDaActividade() + " " + getObjectivoActividade();
    }
}