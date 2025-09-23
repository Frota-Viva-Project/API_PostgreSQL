package org.example.frotavivapostgreapi.repository;

import org.example.frotavivapostgreapi.model.Manutencao;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.web.bind.annotation.PathVariable;

import java.util.List;

public interface ManutencaoRepository extends JpaRepository<Manutencao, Long> {

    @Query(value = "SELECT * FROM manutencao WHERE id = :id_manutencao", nativeQuery = true)
    Manutencao findById(@PathVariable("id_manutencao") Integer id_manutencao);

    @Query(value = "SELECT * FROM manutencao WHERE id_caminhao = :id_caminhao", nativeQuery = true)
    List<Manutencao> findByIdCaminhao(@PathVariable("id_caminhao") Integer id_caminhao);
}
