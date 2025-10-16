package org.example.frotavivapostgreapi.service;

import org.example.frotavivapostgreapi.dto.ServicoResponseDTO;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestParam;

public interface ServicoService {
    ServicoResponseDTO inseriServico(@PathVariable Integer idManutencao, @RequestParam String descServico);
}
