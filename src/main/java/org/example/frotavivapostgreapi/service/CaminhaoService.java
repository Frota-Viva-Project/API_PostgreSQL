package org.example.frotavivapostgreapi.service;

import org.example.frotavivapostgreapi.dto.CaminhaoRequestDTO;
import org.example.frotavivapostgreapi.dto.CaminhaoResponseDTO;
import org.example.frotavivapostgreapi.model.Caminhao;
import org.springframework.data.repository.query.Param;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.List;


public interface CaminhaoService {
    CaminhaoResponseDTO listarCaminhoes(@PathVariable("id_motorista") Integer id_motorista);

    CaminhaoResponseDTO inseriCaminhao(@RequestBody CaminhaoRequestDTO caminhaoRequestDTO, @PathVariable("id_motorista") Integer id_motorista);
}
