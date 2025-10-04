package org.example.frotavivapostgreapi.service;

import org.example.frotavivapostgreapi.dto.ArduinoResponseDTO;
import org.example.frotavivapostgreapi.model.Arduino;
import org.springframework.web.bind.annotation.PathVariable;

public interface ArduinoService {
    ArduinoResponseDTO listById(@PathVariable("id_caminhao") Integer id);
}
