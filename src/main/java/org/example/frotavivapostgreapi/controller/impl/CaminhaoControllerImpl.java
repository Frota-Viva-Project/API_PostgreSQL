package org.example.frotavivapostgreapi.controller.impl;

import org.example.frotavivapostgreapi.controller.CaminhaoController;
import org.springframework.data.repository.query.Param;
import org.springframework.http.ResponseEntity;
import org.example.frotavivapostgreapi.model.Caminhao;
import org.example.frotavivapostgreapi.repository.CaminhaoRepository;
import org.example.frotavivapostgreapi.service.CaminhaoService;
import org.example.frotavivapostgreapi.service.impl.CaminhaoServiceImpl;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("v1/api")
public class CaminhaoControllerImpl implements CaminhaoController {
    private final CaminhaoService caminhaoService;

    public CaminhaoControllerImpl(CaminhaoRepository caminhaoRepository) {
        this.caminhaoService = new CaminhaoServiceImpl(caminhaoRepository);
    }

    @Override
    public ResponseEntity<Caminhao> listById(@PathVariable("id_motorista") Integer id_motorista) {
        Caminhao caminhao = caminhaoService.listarCaminhoes(id_motorista);
        if (caminhao == null) {
            return ResponseEntity.notFound().build();
        }
        return ResponseEntity.ok(caminhao);
    }
}
