package com.webbappgestaoprojectos.repository;

import com.webbappgestaoprojectos.model.Categoria;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

@Repository
public interface CategoriaRepository extends JpaRepository<Categoria, Integer> {
    @Query("select cat from Categoria cat where cat.descricao = ?1")
    Categoria findByCategoria(String categoria);
}
