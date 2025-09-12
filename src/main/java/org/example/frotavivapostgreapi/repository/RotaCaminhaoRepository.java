package org.example.frotavivapostgreapi.repository;

import org.example.frotavivapostgreapi.model.RotaCaminhao;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.web.bind.annotation.PathVariable;

import java.util.List;

public interface RotaCaminhaoRepository extends JpaRepository<RotaCaminhao, Long> {

    @Query(value = "SELECT * FROM rota_caminhao WHERE id_caminhao = :id_caminhao", nativeQuery = true)
    List<RotaCaminhao> findById(@PathVariable("id_caminhao") Integer id_caminhao);
}
