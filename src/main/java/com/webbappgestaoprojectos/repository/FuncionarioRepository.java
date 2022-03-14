package com.webbappgestaoprojectos.repository;

import com.webbappgestaoprojectos.model.Funcionario;
import com.webbappgestaoprojectos.model.Utilizador;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

@Repository
public interface FuncionarioRepository extends JpaRepository<Funcionario, Integer> {
    @Query("select f from Funcionario f where f.utilizador = ?1")
    Funcionario findByUtilizador(Utilizador idUtilizador);
}
