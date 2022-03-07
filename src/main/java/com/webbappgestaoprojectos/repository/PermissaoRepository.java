package com.webbappgestaoprojectos.repository;

import com.webbappgestaoprojectos.model.Permissao;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.Collection;

@Repository
public interface PermissaoRepository extends JpaRepository<Permissao,Integer> {
    @Query("select p from Permissao p where p.descricao = ?1")
    Permissao findByRole(String permissao);

    @Query("select p from Permissao p where p.idPermissao = ?1")
    Permissao retornaPermissao(int permissao);

}
