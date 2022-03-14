package com.webbappgestaoprojectos.repository;

import com.webbappgestaoprojectos.model.FornecedorTransporte;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface FornecedorTransporteRepository extends JpaRepository<FornecedorTransporte, Integer> {
}
