package org.example.frotavivapostgreapi.service.impl;

import org.example.frotavivapostgreapi.model.Arduino;
import org.example.frotavivapostgreapi.repository.ArduinoRepository;
import org.example.frotavivapostgreapi.service.ArduinoService;
import org.springframework.web.bind.annotation.PathVariable;

public class ArduinoServiceImpl implements ArduinoService {
    private final ArduinoRepository arduinoRepository;

    public  ArduinoServiceImpl(ArduinoRepository arduinoRepository) {
        this.arduinoRepository = arduinoRepository;
    }

    @Override
    public Arduino listById(@PathVariable("id_caminhao") Integer id) {
        return arduinoRepository.findByIdCaminhao(id);
    }
}
