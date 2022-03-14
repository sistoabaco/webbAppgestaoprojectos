package com.webbappgestaoprojectos.repository;

import com.webbappgestaoprojectos.model.TermoReferencia;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface TdRRepository extends JpaRepository<TermoReferencia, Integer> {
}
