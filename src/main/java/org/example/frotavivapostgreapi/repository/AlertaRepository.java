package org.example.frotavivapostgreapi.repository;

import org.example.frotavivapostgreapi.model.Alerta;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.web.bind.annotation.PathVariable;

import java.util.List;

public interface AlertaRepository extends JpaRepository<Alerta, Long> {

    @Query(value = "SELECT * FROM alerta WHERE id_caminhao = :id_caminhao",nativeQuery = true)
    List<Alerta> findById(@PathVariable("id_caminhao") Integer id_caminhao);
}
