package org.example.frotavivapostgreapi.controller.impl;

import jakarta.persistence.EntityNotFoundException;
import org.example.frotavivapostgreapi.mapper.GlobalMapper;
import org.example.frotavivapostgreapi.controller.CaminhaoController;
import org.example.frotavivapostgreapi.dto.CaminhaoResponseDTO;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.http.ResponseEntity;
import org.example.frotavivapostgreapi.repository.CaminhaoRepository;
import org.example.frotavivapostgreapi.service.CaminhaoService;
import org.example.frotavivapostgreapi.service.impl.CaminhaoServiceImpl;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("v1/api")
public class CaminhaoControllerImpl implements CaminhaoController {
    private final CaminhaoService caminhaoService;

    public CaminhaoControllerImpl(CaminhaoRepository caminhaoRepository, RedisTemplate<String, Object> redisTemplate, GlobalMapper globalMapper) {
        this.caminhaoService = new CaminhaoServiceImpl(caminhaoRepository,redisTemplate,globalMapper);
    }

    @Override
    public ResponseEntity<CaminhaoResponseDTO> listById(@PathVariable("id_motorista") Integer id_motorista) {
        CaminhaoResponseDTO caminhao = caminhaoService.listarCaminhoes(id_motorista);
        if (caminhao == null) {
            throw new EntityNotFoundException("Caminhão não encontrado com o id_motorista: "+id_motorista);
        }
        return ResponseEntity.ok(caminhao);
    }
}
