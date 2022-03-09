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

    @ManyToOne(cascade = CascadeType.ALL)
    private Categoria categoria;

    @OneToMany
    private Collection <SolicitacaoTransporte> solicitacaoTransporte;

    @OneToMany
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

    @Override
    public String toString(){
        return this.primeiroNome;
    }
}
