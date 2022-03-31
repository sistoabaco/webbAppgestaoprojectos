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
    private String fax;
}
