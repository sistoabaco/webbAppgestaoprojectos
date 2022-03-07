package com.webbappgestaoprojectos.repository;

import com.webbappgestaoprojectos.model.SolicitacaoTransporte;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface SolicitacaoTRepository extends JpaRepository<SolicitacaoTransporte, Integer> {
}
