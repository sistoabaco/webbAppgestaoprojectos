package com.webbappgestaoprojectos.model;

import lombok.*;
import javax.persistence.*;
import java.util.Collection;

@Data
@Getter
@Setter
@Builder
@NoArgsConstructor
@AllArgsConstructor


@Entity
public class Funcionario {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int idFuncionario;

    private String primeiroNome;
    private String sobrenome;
    private String genero;
    private String estadoCivil;
    private String dataNascimento;
    private String endereco;
    private String distrito;
    private String celular;
    private String dataInicio;
    private String dataFim;

    @ManyToOne
    private Categoria categoria;

    @OneToMany(cascade = CascadeType.ALL)
    private Collection <SolicitacaoTransporte> solicitacaoTransporte;

    @OneToMany (cascade = CascadeType.ALL)
    private Collection <TermoReferencia> termoReferencia;

    @OneToOne
    private Utilizador utilizador;

    @ManyToMany
    @JoinTable(
            name = "funcionario_projecto",
            joinColumns = @JoinColumn(
                    name = "idFuncionario", referencedColumnName = "idFuncionario"),
            inverseJoinColumns = @JoinColumn(
                    name = "idProjecto", referencedColumnName = "idProjecto"))
    private Collection <Projecto> projecto;

    public Funcionario(String primeiroNome, String sobrenome, String genero, String estadoCivil,
                       String dataNascimento, String endereco, String distrito, String celular,
                       String dataInicio, String dataFim) {
        this.primeiroNome = primeiroNome;
        this.sobrenome = sobrenome;
        this.genero = genero;
        this.estadoCivil = estadoCivil;
        this.dataNascimento = dataNascimento;
        this.endereco = endereco;
        this.distrito = distrito;
        this.celular = celular;
        this.dataInicio = dataInicio;
        this.dataFim = dataFim;
    }

    @Override
    public String toString(){
        return this.primeiroNome + " " + this.sobrenome;
    }
}
