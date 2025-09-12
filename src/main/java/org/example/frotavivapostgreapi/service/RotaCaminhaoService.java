package org.example.frotavivapostgreapi.service;

import org.example.frotavivapostgreapi.model.RotaCaminhao;
import org.springframework.web.bind.annotation.PathVariable;

import java.util.List;

public interface RotaCaminhaoService {
    List<RotaCaminhao> listById(@PathVariable("id_caminhao") Integer id_caminhao);
}
