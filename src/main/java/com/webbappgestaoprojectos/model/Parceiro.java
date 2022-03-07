package com.webbappgestaoprojectos.model;

import com.sun.istack.NotNull;
import lombok.*;

import javax.persistence.*;
import javax.validation.constraints.Size;
import java.util.Collection;

@Data
@Getter
@Setter
@Builder
@NoArgsConstructor
@AllArgsConstructor

@Entity
public class Parceiro {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int idParceiro;

    private String nomeCompleto;

    @Size (min = 10)
    @Column(unique = true)
    private String nuit;

    private String endereco;

    @Size (min = 5)
    @Column(unique = true)
    private String email;

    public Parceiro(String nomeCompleto, String nuit, String endereco, String email, Utilizador utilizador) {
        this.nomeCompleto = nomeCompleto;
        this.nuit = nuit;
        this.endereco = endereco;
        this.email = email;
        this.projecto = projecto;
        this.utilizador = utilizador;
    }

    @ManyToMany
    @JoinTable(
            name = "financiador_projecto",
            joinColumns = @JoinColumn(
                    name = "idParceiro", referencedColumnName = "idParceiro"),
            inverseJoinColumns = @JoinColumn(
                    name = "idProjecto", referencedColumnName = "idProjecto"))
    private Collection<Projecto> projecto;

    @OneToOne
    private Utilizador utilizador;

    @Override
    public String toString(){
        return this.nomeCompleto;
    }

}
