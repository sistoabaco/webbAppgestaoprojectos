package com.webbappgestaoprojectos.repository;

import com.webbappgestaoprojectos.model.Projecto;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

@Repository
public interface ProjectoRepository extends JpaRepository<Projecto, Integer> {
    @Query("select p from Projecto p where p.nomeProjecto = ?1")
    Projecto findByName(String projecto);
}
