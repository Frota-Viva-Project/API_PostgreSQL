package org.example.frotavivapostgreapi.controller.impl;

import io.swagger.v3.oas.annotations.security.SecurityRequirement;
import jakarta.persistence.EntityNotFoundException;
import jakarta.validation.Valid;
import org.example.frotavivapostgreapi.mapper.GlobalMapper;
import org.example.frotavivapostgreapi.controller.RotaCaminhaoController;
import org.example.frotavivapostgreapi.dto.RotaCaminhaoRequestDTO;
import org.example.frotavivapostgreapi.dto.RotaCaminhaoResponseDTO;
import org.example.frotavivapostgreapi.repository.RotaCaminhaoRepository;
import org.example.frotavivapostgreapi.service.RotaCaminhaoService;
import org.example.frotavivapostgreapi.service.impl.RotaCaminhaoServiceImpl;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@SecurityRequirement(name = "bearerAuth")
@RestController
@RequestMapping("v1/api")
public class RotaCaminhaoControllerImpl implements RotaCaminhaoController {
    private final RotaCaminhaoService rotaCaminhaoService;

    public RotaCaminhaoControllerImpl(RotaCaminhaoRepository rotaCaminhaoRepository, RedisTemplate<String, Object> redisTemplate , GlobalMapper globalMapper) {
        this.rotaCaminhaoService = new RotaCaminhaoServiceImpl(rotaCaminhaoRepository,redisTemplate,globalMapper);
    }

    @Override
    public ResponseEntity<List<RotaCaminhaoResponseDTO>> listById(@PathVariable("id_caminhao") Integer id_caminhao) {
        List<RotaCaminhaoResponseDTO> rotaCaminhao = rotaCaminhaoService.listById(id_caminhao);
        if (rotaCaminhao.isEmpty()) {
            throw new EntityNotFoundException("Rota não encotrada com o id_caminhao: "+id_caminhao);
        }
        return ResponseEntity.ok(rotaCaminhao);
    }

    @Override
    public ResponseEntity<RotaCaminhaoResponseDTO> inseriRotaCaminhao(@Valid @RequestBody RotaCaminhaoRequestDTO rotaCaminhaoRequestDTO, @PathVariable("id_caminhao") Integer id_caminhao){
        RotaCaminhaoResponseDTO rotaCaminhaoResponseDTO = rotaCaminhaoService.inseriRotaCaminhao(rotaCaminhaoRequestDTO,id_caminhao);
        return ResponseEntity.ok(rotaCaminhaoResponseDTO);
    }

    @Override
    public ResponseEntity<HttpStatus> updateStatusToEmRota(@RequestParam("id_rotacaminhao") Integer id_rotacaminhao, @RequestParam("id_caminhao") Integer id_caminhao) {
        rotaCaminhaoService.updateStatusToEmRota(id_rotacaminhao, id_caminhao);
        return ResponseEntity.ok(HttpStatus.OK);
    }

    @Override
    public ResponseEntity<HttpStatus> updateStatusToFinalizada(@RequestParam("id_rotacaminhao") Integer id_rotacaminhao, @RequestParam("id_caminhao") Integer id_caminhao) {
        rotaCaminhaoService.updateStatusToConcluido(id_rotacaminhao, id_caminhao);
        return ResponseEntity.ok(HttpStatus.OK);
    }


}
