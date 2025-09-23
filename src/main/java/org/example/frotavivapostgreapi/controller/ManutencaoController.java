package org.example.frotavivapostgreapi.controller;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.example.frotavivapostgreapi.model.Manutencao;
import org.springframework.web.bind.annotation.PathVariable;

import java.util.List;


public interface ManutencaoController {

    @GetMapping("/manutencao/{id_manutencao}")
    ResponseEntity<Manutencao> listById(@PathVariable("id_manutencao") Integer id_manutencao);

    @GetMapping("/manutencao/caminhao/{id_caminhao}")
    ResponseEntity<List<Manutencao>> listByIdCaminhao(@PathVariable("id_caminhao") Integer id_caminhao);
}
