package org.example.frotavivapostgreapi.controller;

import org.example.frotavivapostgreapi.dto.ServicoResponseDTO;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

public interface ServicoController {

    @PostMapping("/servico/{idManutencao}")
    ResponseEntity<ServicoResponseDTO> inseriServico(@PathVariable Integer idManutencao, @RequestParam String descServico);

}
