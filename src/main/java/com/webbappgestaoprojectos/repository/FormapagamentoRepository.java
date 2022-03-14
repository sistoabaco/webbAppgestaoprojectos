package com.webbappgestaoprojectos.repository;

import com.webbappgestaoprojectos.model.FormaPagamento;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface FormapagamentoRepository extends JpaRepository<FormaPagamento, Integer> {
}
