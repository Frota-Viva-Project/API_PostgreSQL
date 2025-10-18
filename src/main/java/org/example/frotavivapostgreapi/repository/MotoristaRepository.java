package org.example.frotavivapostgreapi.repository;

import io.lettuce.core.dynamic.annotation.Param;
import jakarta.transaction.Transactional;
import org.example.frotavivapostgreapi.model.Motorista;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;

public interface MotoristaRepository extends JpaRepository<Motorista, Long> {

    @Transactional
    @Query(value = "INSERT INTO motorista (id, id_empresa, cod_empresa) " +
            "VALUES (:id, :id_empresa, :cod_empresa)"+
            "RETURNING id",
            nativeQuery = true)
    Integer inserirMotorista(@Param("id") Integer id,
                           @Param("id_empresa") Long id_empresa,
                           @Param("cod_empresa") String cod_empresa);
}
