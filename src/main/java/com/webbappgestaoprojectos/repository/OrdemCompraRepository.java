package com.webbappgestaoprojectos.repository;

import com.webbappgestaoprojectos.model.OrdemCompra;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface OrdemCompraRepository extends JpaRepository<OrdemCompra, Integer> {
}
