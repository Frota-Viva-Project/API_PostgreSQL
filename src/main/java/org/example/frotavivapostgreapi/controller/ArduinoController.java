package org.example.frotavivapostgreapi.controller;

import org.example.frotavivapostgreapi.dto.ArduinoResponseDTO;
import org.example.frotavivapostgreapi.model.Arduino;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

public interface ArduinoController {
    @GetMapping("/arduino/{id_caminhao}")
    ResponseEntity<ArduinoResponseDTO> listById(@PathVariable("id_caminhao") Integer id);
}
