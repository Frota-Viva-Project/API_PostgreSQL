package org.example.frotavivapostgreapi.service.impl;

import org.example.frotavivapostgreapi.Mapper.GlobalMapper;
import org.example.frotavivapostgreapi.dto.CaminhaoResponseDTO;
import org.example.frotavivapostgreapi.dto.EmpresaResponseDTO;
import org.example.frotavivapostgreapi.model.Empresa;
import org.example.frotavivapostgreapi.repository.EmpresaRepository;
import org.example.frotavivapostgreapi.repository.ManutencaoRepository;
import org.example.frotavivapostgreapi.service.EmpresaService;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.web.bind.annotation.PathVariable;

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
}
