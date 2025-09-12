package org.example.frotavivapostgreapi.service;

import org.example.frotavivapostgreapi.model.Manutencao;
import org.springframework.data.jpa.repository.Query;
import org.springframework.web.bind.annotation.PathVariable;

import java.util.List;

public interface ManutecaoService {
    @Query(value = "SELECT * FROM manutencao WHERE id = :id_manutencao", nativeQuery = true)
    Manutencao listById(@PathVariable("id_manutencao") Integer id_manutencao);
}
