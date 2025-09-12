package org.example.frotavivapostgreapi.controller.impl;

import org.example.frotavivapostgreapi.controller.RotaCaminhaoController;
import org.example.frotavivapostgreapi.model.RotaCaminhao;
import org.example.frotavivapostgreapi.repository.ManutencaoRepository;
import org.example.frotavivapostgreapi.repository.RotaCaminhaoRepository;
import org.example.frotavivapostgreapi.service.RotaCaminhaoService;
import org.example.frotavivapostgreapi.service.impl.ManutencaoServiceImpl;
import org.example.frotavivapostgreapi.service.impl.RotaCaminhaoServiceImpl;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("v1/api")
public class RotaCaminhaoControllerImpl implements RotaCaminhaoController {
    private final RotaCaminhaoService rotaCaminhaoService;

    public RotaCaminhaoControllerImpl(RotaCaminhaoRepository rotaCaminhaoRepository) {
        this.rotaCaminhaoService = new RotaCaminhaoServiceImpl(rotaCaminhaoRepository);
    }

    @Override
    public ResponseEntity<List<RotaCaminhao>> listById(@PathVariable("id_caminhao") Integer id_caminhao) {
        List<RotaCaminhao> rotaCaminhao = rotaCaminhaoService.listById(id_caminhao);
        if (rotaCaminhao == null) {
            return ResponseEntity.notFound().build();
        }
        return ResponseEntity.ok(rotaCaminhao);
    }


}
