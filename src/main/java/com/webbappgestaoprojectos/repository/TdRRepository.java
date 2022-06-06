package com.webbappgestaoprojectos.repository;

import com.webbappgestaoprojectos.model.Funcionario;
import com.webbappgestaoprojectos.model.TermoReferencia;
import com.webbappgestaoprojectos.model.Utilizador;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

@Repository
public interface TdRRepository extends JpaRepository<TermoReferencia, Integer> {
}
