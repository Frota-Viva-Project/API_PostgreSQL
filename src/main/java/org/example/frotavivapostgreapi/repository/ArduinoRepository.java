package org.example.frotavivapostgreapi.repository;

import org.example.frotavivapostgreapi.model.Arduino;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.web.bind.annotation.PathVariable;

public interface ArduinoRepository extends JpaRepository<Arduino, Long> {

    @Query(value = "SELECT * FROM arduino WHERE id_caminhao = :id_caminhao", nativeQuery = true)
    Arduino findByIdCaminhao(@PathVariable("id_caminhao") Integer id_caminhao);
}
