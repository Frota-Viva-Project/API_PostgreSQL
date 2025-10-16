package org.example.frotavivapostgreapi.service.impl;

import org.example.frotavivapostgreapi.dto.EmpresaRequestDTO;
import org.example.frotavivapostgreapi.mapper.GlobalMapper;
import org.example.frotavivapostgreapi.dto.EmpresaResponseDTO;
import org.example.frotavivapostgreapi.model.Empresa;
import org.example.frotavivapostgreapi.repository.EmpresaRepository;
import org.example.frotavivapostgreapi.service.EmpresaService;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;

import java.time.Duration;

public class EmpresaServiceImpl implements EmpresaService {
    private final EmpresaRepository empresaRepository;

    private RedisTemplate<String, Object> redisTemplate;

    private final GlobalMapper globalMapper;

    public EmpresaServiceImpl(EmpresaRepository empresaRepository,
                              RedisTemplate<String, Object> redisTemplate,
                              GlobalMapper globalMapper) {
        this.empresaRepository = empresaRepository;
        this.redisTemplate = redisTemplate;
        this.globalMapper = globalMapper;
    }

    @Override
    public EmpresaResponseDTO listById(@PathVariable("id_empresa") Integer id_empresa) {
        String cacheKey = "empresa:"+ id_empresa;

        Object cache = redisTemplate.opsForValue().get(cacheKey);
        if (cache != null) {
            return (EmpresaResponseDTO) cache;
        }

        EmpresaResponseDTO empresaResponseDTO = globalMapper.toEmpresaDTO(empresaRepository.findById(id_empresa));
        redisTemplate.opsForValue().set(cacheKey, empresaResponseDTO, Duration.ofMinutes(10));
        return empresaResponseDTO;
    }

    @Override
    public EmpresaResponseDTO inserirEmpresa(@RequestBody EmpresaRequestDTO empresaRequestDTO) {
        Empresa empresa = globalMapper.toEmpresa(empresaRequestDTO);
        String cod_empresa = empresa.getNome().toLowerCase().replace(" ", "_");
        empresa.setCod_empresa(cod_empresa);
        empresaRepository.inserirEmpresa(empresa.getNome(), empresa.getCnpj(), empresa.getTamanhoEmpresa(), empresa.getTamanhoFrota(), empresa.getTipoEmpresa(), empresa.getAreaAtuacao(), empresa.getRazaoSocial(), empresa.getCnae(), empresa.getTelefone(), empresa.getEndereco(),empresa.getCod_empresa() );
        return globalMapper.toEmpresaDTO(empresa);
    }
}
