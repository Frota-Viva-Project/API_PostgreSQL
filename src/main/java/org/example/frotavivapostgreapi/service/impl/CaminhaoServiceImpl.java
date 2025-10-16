package org.example.frotavivapostgreapi.service.impl;

import org.example.frotavivapostgreapi.mapper.GlobalMapper;
import org.example.frotavivapostgreapi.dto.CaminhaoRequestDTO;
import org.example.frotavivapostgreapi.dto.CaminhaoResponseDTO;
import org.example.frotavivapostgreapi.model.Caminhao;
import org.example.frotavivapostgreapi.repository.CaminhaoRepository;
import org.example.frotavivapostgreapi.service.CaminhaoService;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;

import java.time.Duration;

public class CaminhaoServiceImpl implements CaminhaoService {

    private final CaminhaoRepository caminhaoRepository;

    private RedisTemplate<String, Object> redisTemplate;

    private final GlobalMapper globalMapper;

    public CaminhaoServiceImpl(CaminhaoRepository caminhaoRepository,
                               RedisTemplate<String, Object> redisTemplate,
                               GlobalMapper globalMapper) {
        this.caminhaoRepository = caminhaoRepository;
        this.redisTemplate = redisTemplate;
        this.globalMapper = globalMapper;
    }


    @Override
    public CaminhaoResponseDTO listarCaminhoes(@PathVariable("id_motorista") Integer id_motorista) {
        String cacheKey = "caminhao:"+ id_motorista;

        Object cache = redisTemplate.opsForValue().get(cacheKey);
        if (cache != null) {
            return (CaminhaoResponseDTO) cache;
        }


        CaminhaoResponseDTO caminhao = globalMapper.toCaminhaoDTO(caminhaoRepository.findById(id_motorista));

        redisTemplate.opsForValue().set(cacheKey, caminhao, Duration.ofMinutes(10));
        return caminhao;

    }

    @Override
    public CaminhaoResponseDTO inseriCaminhao(@RequestBody CaminhaoRequestDTO caminhaoRequestDTO, @PathVariable("id_motorista") Integer id_motorista) {
        String cacheKey = "caminhao:" + id_motorista;

        redisTemplate.delete(cacheKey);

        Caminhao caminhao = globalMapper.toCaminhao(caminhaoRequestDTO);
         Integer id = caminhaoRepository.inserirCaminhao(id_motorista, caminhao.getCapacidade() ,caminhao.getPlaca(), caminhao.getModelo());
        caminhao.setStatus("ATIVO");
        caminhao.setId(id.longValue());
        return globalMapper.toCaminhaoDTO(caminhao);
    }
}
