package com.webbappgestaoprojectos.model;

import lombok.*;

import javax.persistence.*;
import java.io.Serializable;
import java.util.Collection;

@Data
@Getter
@Setter
@Builder
@NoArgsConstructor
@AllArgsConstructor

@Entity
public class Projecto implements Serializable {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int idProjecto;

    private String nomeProjecto;
    private String estado;//terminado ou activo
    private double Orcamento;
    private String localImplementacao;
    private String dataInicio;
    private String DataFim;
    private String tipoMoeda;
    private double saldoDisponivel;

    public Projecto(String nomeProjecto, String estado, double orcamento, String localImplementacao, String dataInicio, String dataFim, String tipoMoeda, double saldoDisponivel) {
        this.nomeProjecto = nomeProjecto;
        this.estado = estado;
        this.Orcamento = orcamento;
        this.localImplementacao = localImplementacao;
        this.dataInicio = dataInicio;
        this.DataFim = dataFim;
        this.tipoMoeda = tipoMoeda;
        this.saldoDisponivel = saldoDisponivel;
    }

    @ManyToMany(mappedBy = "projecto")
    private Collection <Parceiro> parceiro;

    @ManyToMany(mappedBy = "projecto")
    private Collection <TermoReferencia> termoReferencia;

    @OneToMany
    private Collection <SolicitacaoTransporte> solicitacaoTransportes;

    @ManyToMany(mappedBy = "projecto")
    private Collection <Funcionario> funcionario;

    @Override
    public String toString(){
        return this.nomeProjecto;
    }

}
