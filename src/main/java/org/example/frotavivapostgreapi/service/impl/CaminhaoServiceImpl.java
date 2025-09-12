package org.example.frotavivapostgreapi.service.impl;

import org.example.frotavivapostgreapi.model.Caminhao;
import org.example.frotavivapostgreapi.repository.CaminhaoRepository;
import org.example.frotavivapostgreapi.service.CaminhaoService;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.data.repository.query.Param;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.List;

public class CaminhaoServiceImpl implements CaminhaoService {

    private final CaminhaoRepository caminhaoRepository;

    public CaminhaoServiceImpl(CaminhaoRepository caminhaoRepository) {
        this.caminhaoRepository = caminhaoRepository;
    }


    @Override
    @Cacheable("caminhoes")
    public Caminhao listarCaminhoes(@PathVariable("id_motorista") Integer id_motorista) {
        return caminhaoRepository.findById(id_motorista);
    }
}
