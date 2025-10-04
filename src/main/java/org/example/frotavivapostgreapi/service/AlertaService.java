package org.example.frotavivapostgreapi.service;

import org.example.frotavivapostgreapi.dto.AlertaResponseDTO;
import org.example.frotavivapostgreapi.model.Alerta;
import org.example.frotavivapostgreapi.model.Arduino;
import org.springframework.web.bind.annotation.PathVariable;

import java.util.List;

public interface AlertaService {
    List<AlertaResponseDTO> listarAlertas(@PathVariable("id_caminhao") Integer id_caminhao);
}
