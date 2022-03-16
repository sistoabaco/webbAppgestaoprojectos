package com.webbappgestaoprojectos.repository;

import com.webbappgestaoprojectos.model.Utilizador;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

@Repository
public interface UtilizadorRepository extends JpaRepository<Utilizador, Integer> {
    @Query("select u from Utilizador u where u.username = ?1")
    Utilizador findByUsername(String username);
}
