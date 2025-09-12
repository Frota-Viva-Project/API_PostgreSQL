package org.example.frotavivapostgreapi.service.impl;

import org.example.frotavivapostgreapi.model.RotaCaminhao;
import org.example.frotavivapostgreapi.repository.RotaCaminhaoRepository;
import org.example.frotavivapostgreapi.service.RotaCaminhaoService;
import org.springframework.web.bind.annotation.PathVariable;

import java.util.List;

public class RotaCaminhaoServiceImpl implements RotaCaminhaoService {
    private final RotaCaminhaoRepository rotaCaminhaoRepository;

    public RotaCaminhaoServiceImpl(RotaCaminhaoRepository rotaCaminhaoRepository) {
        this.rotaCaminhaoRepository = rotaCaminhaoRepository;
    }

    @Override
    public List<RotaCaminhao> listById(@PathVariable("id_caminhao") Integer id_caminhao) {
        return rotaCaminhaoRepository.findById(id_caminhao);
    }
}
