package org.example.frotavivapostgreapi.service.impl;

import org.example.frotavivapostgreapi.dto.ServicoResponseDTO;
import org.example.frotavivapostgreapi.mapper.GlobalMapper;
import org.example.frotavivapostgreapi.model.Servico;
import org.example.frotavivapostgreapi.repository.ServicoRepository;
import org.example.frotavivapostgreapi.service.ServicoService;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.Date;

public class ServicoServiceImpl implements ServicoService {
    private final ServicoRepository servicoRepository;

    private final GlobalMapper globalMapper;

    public ServicoServiceImpl(ServicoRepository servicoRepository,
                              GlobalMapper globalMapper) {
        this.servicoRepository = servicoRepository;
        this.globalMapper = globalMapper;
    }

    @Override
    public ServicoResponseDTO inseriServico(@PathVariable Integer idManutencao, @RequestParam String descServico) {
        Integer id = servicoRepository.inserirServico(descServico, new Date(), idManutencao);
        Servico servico = new Servico();
        servico.setDescServico(descServico);
        servico.setDataInicio(new Date());
        servico.setId(id.longValue());
        return globalMapper.toServicoDTO(servico);
    }
}
