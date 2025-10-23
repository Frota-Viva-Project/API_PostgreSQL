package org.example.frotavivapostgreapi.controller.impl;

import jakarta.persistence.EntityNotFoundException;
import jakarta.validation.Valid;
import org.example.frotavivapostgreapi.mapper.GlobalMapper;
import org.example.frotavivapostgreapi.controller.AlertaController;
import org.example.frotavivapostgreapi.dto.AlertaRequestDTO;
import org.example.frotavivapostgreapi.dto.AlertaResponseDTO;
import org.example.frotavivapostgreapi.repository.AlertaRepository;
import org.example.frotavivapostgreapi.service.AlertaService;
import org.example.frotavivapostgreapi.service.impl.AlertaServiceImpl;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
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
        if (alertas.isEmpty()) {
            throw new EntityNotFoundException("Alerta não encontrado com o id_caminhao: "+id_caminhao);
        }
        return ResponseEntity.ok(alertas);
    }

    public ResponseEntity<AlertaResponseDTO> inserirAlerta(@PathVariable("id_caminhao") Integer id_caminhao, @Valid @RequestBody AlertaRequestDTO alertaRequestDTO){
        AlertaResponseDTO alerta = alertaService.inserirAlerta(id_caminhao, alertaRequestDTO);
        return ResponseEntity.ok(alerta);
    }

    public ResponseEntity<HttpStatus> finalizarAlerta(@RequestParam("id_alerta") Integer id_alerta, @RequestParam("id_caminhao") Integer id_caminhao){
        alertaService.finalizarAlerta(id_alerta, id_caminhao);
        return ResponseEntity.ok(HttpStatus.OK);
    }
}
