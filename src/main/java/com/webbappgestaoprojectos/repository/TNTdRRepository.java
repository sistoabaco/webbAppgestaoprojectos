package com.webbappgestaoprojectos.repository;

import com.webbappgestaoprojectos.model.TabelaNecessidadeTdR;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface TNTdRRepository extends JpaRepository<TabelaNecessidadeTdR,Integer> {
}
