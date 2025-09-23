package org.example.frotavivapostgreapi.repository;

import org.example.frotavivapostgreapi.model.Empresa;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

public interface EmpresaRepository extends JpaRepository<Empresa, Long> {

    @Query(value = "SELECT * FROM empresa WHERE id = :id", nativeQuery = true)
    Empresa findById(@Param("id") Integer id);
}
