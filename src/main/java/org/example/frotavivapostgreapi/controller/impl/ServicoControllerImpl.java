package org.example.frotavivapostgreapi.controller.impl;

import org.example.frotavivapostgreapi.controller.ServicoController;
import org.example.frotavivapostgreapi.dto.ServicoResponseDTO;
import org.example.frotavivapostgreapi.mapper.GlobalMapper;
import org.example.frotavivapostgreapi.repository.ServicoRepository;
import org.example.frotavivapostgreapi.service.ServicoService;
import org.example.frotavivapostgreapi.service.impl.ServicoServiceImpl;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("v1/api")
public class ServicoControllerImpl implements ServicoController {
    private final ServicoService servicoService;


    public ServicoControllerImpl(ServicoRepository servicoRepository, GlobalMapper globalMapper) {
        this.servicoService = new ServicoServiceImpl(servicoRepository,globalMapper);
    }

    @Override
    public ResponseEntity<ServicoResponseDTO> inseriServico(@PathVariable Integer idManutencao, @RequestParam String descServico) {
        return ResponseEntity.ok(servicoService.inseriServico(idManutencao, descServico));
    }
}
