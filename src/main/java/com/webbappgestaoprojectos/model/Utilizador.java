package com.webbappgestaoprojectos.model;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.sun.istack.NotNull;
import lombok.*;
import javax.persistence.*;
import javax.validation.constraints.Size;
import java.io.Serializable;
import java.util.Collection;

@Data
@Getter
@Setter
@Builder
@NoArgsConstructor
@AllArgsConstructor

@Entity
public class Utilizador implements Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int idUtilizador;

    @Size(min = 5)
    @Column(unique = true)
    private String username;

    @Size(min = 8)
    private String password;

    @ManyToMany(fetch = FetchType.EAGER)
    @JoinTable(
            name = "utilizador_permissao",
            joinColumns = @JoinColumn(
                    name = "idUtilizador", referencedColumnName = "idUtilizador"),
            inverseJoinColumns = @JoinColumn(
                    name = "idPermissao", referencedColumnName = "idPermissao"))
    private Collection<Permissao> permissao;

    public Utilizador(String username, String password){
        this.username = username;
        this.password = password;
    }

    @Override
    public String toString(){
        return this.username;
    }
}
