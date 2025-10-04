package org.example.frotavivapostgreapi.controller.impl;

import org.example.frotavivapostgreapi.Mapper.GlobalMapper;
import org.example.frotavivapostgreapi.controller.AlertaController;
import org.example.frotavivapostgreapi.dto.AlertaResponseDTO;
import org.example.frotavivapostgreapi.model.Alerta;
import org.example.frotavivapostgreapi.repository.AlertaRepository;
import org.example.frotavivapostgreapi.repository.ArduinoRepository;
import org.example.frotavivapostgreapi.service.AlertaService;
import org.example.frotavivapostgreapi.service.CaminhaoService;
import org.example.frotavivapostgreapi.service.impl.AlertaServiceImpl;
import org.example.frotavivapostgreapi.service.impl.ArduinoServiceImpl;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("v1/api")
public class AlertaControllerImpl implements AlertaController {

    private final AlertaService alertaService;

    public AlertaControllerImpl(AlertaRepository alertaRepository, RedisTemplate<String, Object> redisTemplate, GlobalMapper globalMapper) {
        this.alertaService = new AlertaServiceImpl(alertaRepository,redisTemplate,globalMapper);
    }

    public ResponseEntity<List<AlertaResponseDTO>> listarAlertas(@PathVariable("id_caminhao") Integer id_caminhao){
        List<AlertaResponseDTO> alertas = alertaService.listarAlertas(id_caminhao);
        if (alertas == null) {
            return ResponseEntity.noContent().build();
        }
        return ResponseEntity.ok(alertas);
    }
}
