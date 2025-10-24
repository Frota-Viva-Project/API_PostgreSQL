package org.example.frotavivapostgreapi.controller.impl;

import io.lettuce.core.dynamic.annotation.Param;
import jakarta.persistence.EntityNotFoundException;
import jakarta.validation.Valid;
import org.example.frotavivapostgreapi.mapper.GlobalMapper;
import org.example.frotavivapostgreapi.controller.ManutencaoController;
import org.example.frotavivapostgreapi.dto.ManutencaoRequestDTO;
import org.example.frotavivapostgreapi.dto.ManutencaoResponseDTO;
import org.example.frotavivapostgreapi.repository.ManutencaoRepository;
import org.example.frotavivapostgreapi.service.ManutecaoService;
import org.example.frotavivapostgreapi.service.impl.ManutencaoServiceImpl;
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
public class ManutencaoControllerImpl implements ManutencaoController {
    private final ManutecaoService manutencaoService;

    public ManutencaoControllerImpl(ManutencaoRepository manutencaoRepository, RedisTemplate<String, Object> redisTemplate, GlobalMapper globalMapper) {
        this.manutencaoService = new ManutencaoServiceImpl(manutencaoRepository, redisTemplate, globalMapper);
    }


    @Override
    public ResponseEntity<List<ManutencaoResponseDTO>> listByIdCaminhao(@PathVariable("id_caminhao") Integer id_caminhao) {
        List<ManutencaoResponseDTO> manutencao = manutencaoService.listByIdCaminhao(id_caminhao);
        if (manutencao.isEmpty()) {
            throw new EntityNotFoundException("Manutenção não encontrada com o id_caminhao: "+id_caminhao);
        }
        return ResponseEntity.ok(manutencao);
    }

    @Override
    public ResponseEntity<ManutencaoResponseDTO> inseriManutencao(@Valid @RequestBody ManutencaoRequestDTO manutencaoRequestDTO, @PathVariable("id_caminhao") Integer id_caminhao) {
        ManutencaoResponseDTO manutencao = manutencaoService.inseriManutencao(manutencaoRequestDTO, id_caminhao);
        return ResponseEntity.ok(manutencao);
    }

    @Override
    public ResponseEntity<HttpStatus> finalizarManutencao(@RequestParam Integer id_manuntecao,@RequestParam("id_caminhao") Integer id_caminhao) {
        manutencaoService.finalizarManutencao(id_manuntecao,id_caminhao);
        return ResponseEntity.ok(HttpStatus.OK);

    }

}
