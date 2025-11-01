package org.example.frotavivapostgreapi.controller.impl;

import jakarta.validation.Valid;
import org.example.frotavivapostgreapi.controller.MotoristaController;
import org.example.frotavivapostgreapi.dto.CaminhaoRequestDTO;
import org.example.frotavivapostgreapi.dto.CaminhaoResponseDTO;
import org.example.frotavivapostgreapi.mapper.GlobalMapper;
import org.example.frotavivapostgreapi.repository.CaminhaoRepository;
import org.example.frotavivapostgreapi.repository.EmpresaRepository;
import org.example.frotavivapostgreapi.repository.MotoristaRepository;
import org.example.frotavivapostgreapi.service.CaminhaoService;
import org.example.frotavivapostgreapi.service.MotoristaService;
import org.example.frotavivapostgreapi.service.impl.CaminhaoServiceImpl;
import org.example.frotavivapostgreapi.service.impl.MotoristaServiceImpl;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("v1/api")
public class MotoristaControllerImpl implements MotoristaController {
    private final MotoristaService motoristaService;

    public MotoristaControllerImpl(MotoristaRepository motoristaRepository, GlobalMapper globalMapper, EmpresaRepository empresaRepository, CaminhaoRepository caminhaoRepository) {
        this.motoristaService = new MotoristaServiceImpl(motoristaRepository,globalMapper,empresaRepository,caminhaoRepository);
    }


    public ResponseEntity<CaminhaoResponseDTO> inserirMotorista(@Valid @RequestBody CaminhaoRequestDTO caminhaoRequestDTO, @PathVariable("id_motorista") Integer id_motorista, @RequestParam("cod_empresa") String cod_empresa){
        return ResponseEntity.ok(motoristaService.inseriMotorista(id_motorista, caminhaoRequestDTO, cod_empresa));
    }

    public ResponseEntity<Integer> buscarMotoristaPorCaminhao(@PathVariable("id") Integer id){
        return ResponseEntity.ok(motoristaService.buscarMotoristaPorCaminhao(id));
    }

}
