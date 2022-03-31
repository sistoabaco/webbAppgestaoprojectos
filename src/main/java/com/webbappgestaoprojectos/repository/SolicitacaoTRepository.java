package com.webbappgestaoprojectos.repository;

import com.webbappgestaoprojectos.model.SolicitacaoTransporte;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.Collection;

@Repository
public interface SolicitacaoTRepository extends JpaRepository<SolicitacaoTransporte, Integer> {
    @Query("select st from SolicitacaoTransporte st where st.status = ?1")
    Collection <SolicitacaoTransporte> findByStatus(String status);

    @Query("select c from SolicitacaoTransporte c where c.coordenador is not null")
    Collection <SolicitacaoTransporte> findByCoordenadorST();

    @Query("select l from SolicitacaoTransporte l where l.logistico is not null")
    Collection <SolicitacaoTransporte> findByLogisticoST();
}
