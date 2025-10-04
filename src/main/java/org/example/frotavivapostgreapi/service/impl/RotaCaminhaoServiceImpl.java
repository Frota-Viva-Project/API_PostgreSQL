package org.example.frotavivapostgreapi.service.impl;

import org.example.frotavivapostgreapi.Mapper.GlobalMapper;
import org.example.frotavivapostgreapi.dto.RotaCaminhaoRequestDTO;
import org.example.frotavivapostgreapi.dto.RotaCaminhaoResponseDTO;
import org.example.frotavivapostgreapi.model.RotaCaminhao;
import org.example.frotavivapostgreapi.repository.RotaCaminhaoRepository;
import org.example.frotavivapostgreapi.service.RotaCaminhaoService;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;

import java.time.Duration;
import java.util.ArrayList;
import java.util.List;

public class RotaCaminhaoServiceImpl implements RotaCaminhaoService {
    private final RotaCaminhaoRepository rotaCaminhaoRepository;

    private RedisTemplate<String, Object> redisTemplate;

    private final GlobalMapper globalMapper;

    public RotaCaminhaoServiceImpl(RotaCaminhaoRepository rotaCaminhaoRepository,
                                   RedisTemplate<String, Object> redisTemplate,
                                   GlobalMapper globalMapper) {
        this.rotaCaminhaoRepository = rotaCaminhaoRepository;
        this.redisTemplate = redisTemplate;
        this.globalMapper = globalMapper;
    }

    @Override
    public List<RotaCaminhaoResponseDTO> listById(@PathVariable("id_caminhao") Integer id_caminhao) {
        String cacheKey = "rota_caminhao:" + id_caminhao;

        Object cache = redisTemplate.opsForValue().get(cacheKey);
        if (cache != null) {
            return (List<RotaCaminhaoResponseDTO>) cache;
        }

        List<RotaCaminhao> rotaCaminhoes = rotaCaminhaoRepository.findById(id_caminhao);
        List<RotaCaminhaoResponseDTO> responseDTO = new ArrayList<>();
        for (RotaCaminhao rotaCaminhao : rotaCaminhoes) {
            responseDTO.add(globalMapper.toRotaCaminhaoDTO(rotaCaminhao));
        }
        redisTemplate.opsForValue().set(cacheKey, responseDTO, Duration.ofMinutes(10));
        return responseDTO;
    }

    @Override
    public RotaCaminhaoResponseDTO inseriRotaCaminhao(@RequestBody RotaCaminhaoRequestDTO rotaCaminhaoRequestDTO,@PathVariable("id_caminhao") Integer id_caminhao){
        RotaCaminhao rotaCaminhao = globalMapper.toRotaCaminhao(rotaCaminhaoRequestDTO);
        rotaCaminhaoRepository.inserirRotaCaminhao(
                id_caminhao,
                "ATIVA",
                rotaCaminhao.getDestinoInicial(),
                rotaCaminhao.getDestinoFinal(),
                rotaCaminhao.getDistancia(),
                rotaCaminhao.getDataChegadaPrevista()
        );
        return globalMapper.toRotaCaminhaoDTO(rotaCaminhao);
    }
}
