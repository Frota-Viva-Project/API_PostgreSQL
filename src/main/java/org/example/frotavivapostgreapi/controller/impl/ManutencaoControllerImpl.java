package org.example.frotavivapostgreapi.controller.impl;

import org.example.frotavivapostgreapi.controller.ManutencaoController;
import org.example.frotavivapostgreapi.model.Manutencao;
import org.example.frotavivapostgreapi.repository.ManutencaoRepository;
import org.example.frotavivapostgreapi.service.ManutecaoService;
import org.example.frotavivapostgreapi.service.impl.ManutencaoServiceImpl;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("v1/api")
public class ManutencaoControllerImpl implements ManutencaoController {
    private final ManutecaoService manutencaoService;

    public ManutencaoControllerImpl(ManutencaoRepository manutencaoRepository) {
        this.manutencaoService = new ManutencaoServiceImpl(manutencaoRepository);
    }

    @Override
    public ResponseEntity<Manutencao> listById(@PathVariable("id_manutencao") Integer id_manutencao) {
        Manutencao manutencao = manutencaoService.listById(id_manutencao);
        if (manutencao == null) {
            return ResponseEntity.notFound().build();
        }
        return ResponseEntity.ok(manutencao);
    }

}
