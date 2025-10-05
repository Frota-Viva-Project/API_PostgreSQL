package org.example.frotavivapostgreapi.repository;

import org.example.frotavivapostgreapi.model.Caminhao;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.List;

public interface CaminhaoRepository extends JpaRepository<Caminhao, Long> {

    @Query(value = "SELECT * FROM caminhao WHERE id_motorista = :id_motorista", nativeQuery = true)
    Caminhao findById(@PathVariable("id_motorista") Integer id_motorista);

}
