package org.example.frotavivapostgreapi.service.impl;

import org.example.frotavivapostgreapi.model.Manutencao;
import org.example.frotavivapostgreapi.repository.ManutencaoRepository;
import org.example.frotavivapostgreapi.service.ManutecaoService;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.web.bind.annotation.PathVariable;

import java.util.List;

public class ManutencaoServiceImpl implements ManutecaoService {
    private final ManutencaoRepository manutencaoRepository;

    public ManutencaoServiceImpl(ManutencaoRepository manutencaoRepository) {
        this.manutencaoRepository = manutencaoRepository;
    }

    @Override
    @Cacheable("manutencaos")
    public Manutencao listById(@PathVariable("id_manutencao") Integer id_manutencao) {
        return manutencaoRepository.findById(id_manutencao);
    }

    @Override
    public List<Manutencao> listByIdCaminhao(@PathVariable("id_caminhao") Integer id_caminhao) {
        return manutencaoRepository.findByIdCaminhao(id_caminhao);
    }
}
