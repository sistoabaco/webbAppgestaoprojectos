package com.webbappgestaoprojectos.model;

import lombok.*;
import javax.persistence.*;
import java.util.Collection;

@Getter
@Setter
@Builder
@NoArgsConstructor
@AllArgsConstructor

@Entity
public class FornecedorTransporte {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer idFornecedor;

    private String nomeCompleto;
    private String nuit;
    private String endereco;
    private String fax_tel;
    private String email;

    public FornecedorTransporte(String nomeCompleto, String nuit, String endereco, String fax, String email) {
        this.nomeCompleto = nomeCompleto;
        this.nuit = nuit;
        this.endereco = endereco;
        this.fax_tel = fax;
        this.email = email;
    }

    @Override
    public String toString(){
        return this.nomeCompleto;
    }
}
