package org.example.frotavivapostgreapi.controller;

import org.example.frotavivapostgreapi.model.RotaCaminhao;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

import java.util.List;

public interface RotaCaminhaoController {
    @GetMapping("/rota_caminhao/{id_caminhao}")
    ResponseEntity<List<RotaCaminhao>> listById(@PathVariable("id_caminhao") Integer id_caminhao);
}
