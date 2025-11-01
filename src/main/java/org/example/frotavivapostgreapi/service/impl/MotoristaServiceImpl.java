package org.example.frotavivapostgreapi.service.impl;

import org.example.frotavivapostgreapi.dto.CaminhaoRequestDTO;
import org.example.frotavivapostgreapi.dto.CaminhaoResponseDTO;
import org.example.frotavivapostgreapi.mapper.GlobalMapper;
import org.example.frotavivapostgreapi.model.Caminhao;
import org.example.frotavivapostgreapi.model.Empresa;
import org.example.frotavivapostgreapi.repository.CaminhaoRepository;
import org.example.frotavivapostgreapi.repository.EmpresaRepository;
import org.example.frotavivapostgreapi.repository.MotoristaRepository;
import org.example.frotavivapostgreapi.service.MotoristaService;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;

public class MotoristaServiceImpl implements MotoristaService{
    private final MotoristaRepository motoristaRepository;

    private final EmpresaRepository empresaRepository;

    private final CaminhaoRepository caminhaoRepository;

    private final GlobalMapper globalMapper;

    public MotoristaServiceImpl(MotoristaRepository motoristaRepository,
                                GlobalMapper globalMapper,
                                EmpresaRepository empresaRepository,
                                CaminhaoRepository caminhaoRepository) {
        this.motoristaRepository = motoristaRepository;
        this.globalMapper = globalMapper;
        this.empresaRepository = empresaRepository;
        this.caminhaoRepository = caminhaoRepository;
    }

    public CaminhaoResponseDTO inseriMotorista(@PathVariable("id_motorista") Integer id_motorista, @RequestBody CaminhaoRequestDTO caminhaoRequestDTO , @RequestParam("cod_empresa") String cod_empresa){
        Empresa empresa = empresaRepository.findByCodEmpresa(cod_empresa);
        motoristaRepository.inserirMotorista(id_motorista, empresa.getId(), cod_empresa);
        Caminhao caminhao = globalMapper.toCaminhao(caminhaoRequestDTO);
        Integer id = caminhaoRepository.inserirCaminhao(id_motorista, caminhao.getCapacidade() ,caminhao.getPlaca(), caminhao.getModelo());
        caminhao.setStatus("ATIVO");
        caminhao.setId(id.longValue());
        return globalMapper.toCaminhaoDTO(caminhao);
    }

    public Integer buscarMotoristaPorCaminhao(@PathVariable("id") Integer id){
        return motoristaRepository.buscarMotoristaPorCaminhao(id);
    }
}
