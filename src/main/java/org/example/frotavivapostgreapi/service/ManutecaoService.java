package org.example.frotavivapostgreapi.service;

import org.example.frotavivapostgreapi.model.Manutencao;

import org.springframework.web.bind.annotation.PathVariable;

import java.util.List;

public interface ManutecaoService {

    Manutencao listById(@PathVariable("id_manutencao") Integer id_manutencao);

    List<Manutencao> listByIdCaminhao(@PathVariable("id_caminhao") Integer id_caminhao);
}
