package org.example.frotavivapostgreapi.service;

import org.example.frotavivapostgreapi.dto.RotaCaminhaoRequestDTO;
import org.example.frotavivapostgreapi.dto.RotaCaminhaoResponseDTO;
import org.example.frotavivapostgreapi.model.RotaCaminhao;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;

import java.util.List;

public interface RotaCaminhaoService {
    List<RotaCaminhaoResponseDTO> listById(@PathVariable("id_caminhao") Integer id_caminhao);

    RotaCaminhaoResponseDTO inseriRotaCaminhao(@RequestBody RotaCaminhaoRequestDTO rotaCaminhaoRequestDTO,@PathVariable("id_caminhao") Integer id_caminhao);
}
