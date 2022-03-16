package com.webbappgestaoprojectos.repository;

import com.webbappgestaoprojectos.model.Funcionario;
import com.webbappgestaoprojectos.model.Parceiro;
import com.webbappgestaoprojectos.model.Utilizador;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

public interface ParceiroRepository extends JpaRepository<Parceiro, Integer> {
    @Query("select p from Parceiro p where p.email = ?1")
    Parceiro findByEmail(String email);

    @Query("select p from Parceiro p where p.utilizador = ?1")
    Parceiro findByUtilizador(Utilizador idUtilizador);

}
