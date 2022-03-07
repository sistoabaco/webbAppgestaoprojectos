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
public class Categoria {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int idCategoria;
    private String descricao;
    private Double salario;

    @OneToMany
    private Collection<Funcionario> funcionario;

    public Categoria(String descricao, Double salario){
        this.descricao = descricao;
        this.salario = salario;
    }

    @Override
    public String toString(){
        return descricao;
    }
}

