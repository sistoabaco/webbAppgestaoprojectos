package com.webbappgestaoprojectos.repository;

import com.webbappgestaoprojectos.model.RequisicaoPagamento;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface RequisicaoPagamentoRepository extends JpaRepository<RequisicaoPagamento, Integer> {
}
