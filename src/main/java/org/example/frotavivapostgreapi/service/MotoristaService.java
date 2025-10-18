package org.example.frotavivapostgreapi.service;

import org.example.frotavivapostgreapi.dto.CaminhaoRequestDTO;
import org.example.frotavivapostgreapi.dto.CaminhaoResponseDTO;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;

public interface MotoristaService {
    CaminhaoResponseDTO inseriMotorista(@PathVariable("id_motorista") Integer id_motorista, @RequestBody CaminhaoRequestDTO caminhaoRequestDTO, @RequestParam("cod_empresa") String cod_empresa);
}
