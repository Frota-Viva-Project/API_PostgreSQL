package org.example.frotavivapostgreapi.service.impl;

import org.example.frotavivapostgreapi.mapper.GlobalMapper;
import org.example.frotavivapostgreapi.dto.ManutencaoRequestDTO;
import org.example.frotavivapostgreapi.dto.ManutencaoResponseDTO;
import org.example.frotavivapostgreapi.model.Manutencao;
import org.example.frotavivapostgreapi.repository.ManutencaoRepository;
import org.example.frotavivapostgreapi.service.ManutecaoService;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;

import java.time.Duration;
import java.util.ArrayList;
import java.util.List;

public class ManutencaoServiceImpl implements ManutecaoService {
    private final ManutencaoRepository manutencaoRepository;

    private RedisTemplate<String, Object> redisTemplate;

    private final GlobalMapper globalMapper;

    public ManutencaoServiceImpl(ManutencaoRepository manutencaoRepository,
                                 RedisTemplate<String, Object> redisTemplate,
                                 GlobalMapper globalMapper) {
        this.manutencaoRepository = manutencaoRepository;
        this.redisTemplate = redisTemplate;
        this.globalMapper = globalMapper;
    }


    @Override
    public List<ManutencaoResponseDTO> listByIdCaminhao(@PathVariable("id_caminhao") Integer id_caminhao) {
        String cacheKey = "manutencao:" + id_caminhao;

        Object cache = redisTemplate.opsForValue().get(cacheKey);
        if (cache != null) {
            return (List<ManutencaoResponseDTO>) cache;
        }

        List<Manutencao> manutencoes = manutencaoRepository.findByIdCaminhao(id_caminhao);
        List<ManutencaoResponseDTO> manutencaoResponseDTO = new ArrayList<>();
        for (Manutencao manutencao : manutencoes) {
            manutencaoResponseDTO.add(globalMapper.toManutencaoDTO(manutencao));
        }
        redisTemplate.opsForValue().set(cacheKey, manutencaoResponseDTO, Duration.ofMinutes(10));
        return manutencaoResponseDTO;
    }

    @Override
    public ManutencaoResponseDTO inseriManutencao(@RequestBody ManutencaoRequestDTO manutencaoRequestDTO, @PathVariable("id_caminhao") Integer id_caminhao) {
        String cacheKey = "manutencao:" + id_caminhao;

        redisTemplate.delete(cacheKey);

        Manutencao manutencao = globalMapper.toManutencao(manutencaoRequestDTO);
        Integer id = manutencaoRepository.inserirManutencao(id_caminhao, manutencao.getInfo(), manutencao.getTitulo());
        manutencao.setStatus(true);
        manutencao.setId(id.longValue());
        return globalMapper.toManutencaoDTO(manutencao);
    }
}
