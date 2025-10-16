package org.example.frotavivapostgreapi.controller.impl;

import org.example.frotavivapostgreapi.mapper.GlobalMapper;
import org.example.frotavivapostgreapi.controller.ArduinoController;
import org.example.frotavivapostgreapi.dto.ArduinoResponseDTO;
import org.example.frotavivapostgreapi.repository.ArduinoRepository;
import org.example.frotavivapostgreapi.service.ArduinoService;
import org.example.frotavivapostgreapi.service.impl.ArduinoServiceImpl;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("v1/api")
public class ArduinoControllerImpl implements ArduinoController {
    private final ArduinoService arduinoService;

    public ArduinoControllerImpl(ArduinoRepository arduinoRepository, RedisTemplate<String, Object> redisTemplate, GlobalMapper globalMapper) {
        this.arduinoService = new ArduinoServiceImpl(arduinoRepository, redisTemplate, globalMapper);
    }

    @Override
    public ResponseEntity<ArduinoResponseDTO> listById(@PathVariable("id_caminhao") Integer id) {
        ArduinoResponseDTO arduino = arduinoService.listById(id);
        if (arduino == null) {
            return ResponseEntity.notFound().build();
        }
        return ResponseEntity.ok(arduino);
    }

}
