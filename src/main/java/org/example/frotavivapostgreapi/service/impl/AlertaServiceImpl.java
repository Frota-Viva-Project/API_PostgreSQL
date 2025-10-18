package org.example.frotavivapostgreapi.service.impl;

import io.lettuce.core.dynamic.annotation.Param;
import org.example.frotavivapostgreapi.mapper.GlobalMapper;
import org.example.frotavivapostgreapi.dto.AlertaRequestDTO;
import org.example.frotavivapostgreapi.dto.AlertaResponseDTO;
import org.example.frotavivapostgreapi.model.Alerta;
import org.example.frotavivapostgreapi.repository.AlertaRepository;
import org.example.frotavivapostgreapi.service.AlertaService;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.web.bind.annotation.PathVariable;

import java.time.Duration;
import java.util.ArrayList;
import java.util.List;

public class AlertaServiceImpl implements AlertaService {

    private final AlertaRepository alertaRepository;

    private RedisTemplate<String, Object> redisTemplate;

    private final GlobalMapper globalMapper;

    public AlertaServiceImpl(AlertaRepository alertaRepository,
                             RedisTemplate<String, Object> redisTemplate,
                             GlobalMapper globalMapper) {
        this.alertaRepository = alertaRepository;
        this.redisTemplate = redisTemplate;
        this.globalMapper = globalMapper;
    }

    @Override
    public List<AlertaResponseDTO> listarAlertas(@PathVariable("id_caminhao") Integer id_caminhao){
        String cacheKey = "alerta:"+ id_caminhao;

        Object cache = redisTemplate.opsForValue().get(cacheKey);
        if (cache != null) {
            return (List<AlertaResponseDTO>) cache;
        }

        List<Alerta> alertas = alertaRepository.findById(id_caminhao);
        List<AlertaResponseDTO> alertaResponseDTO = new ArrayList<>();
        for (Alerta alerta : alertas) {
            alertaResponseDTO.add(globalMapper.toAlertaDTO(alerta));
        }
        redisTemplate.opsForValue().set(cacheKey, alertaResponseDTO, Duration.ofMinutes(10));
        return alertaResponseDTO;


    }

    @Override
    public AlertaResponseDTO inserirAlerta(@PathVariable("id_caminhao") Integer id_caminhao, AlertaRequestDTO alertaRequestDTO){
        String cacheKey = "alerta:" + id_caminhao;
        redisTemplate.delete(cacheKey);

        Alerta alerta = globalMapper.toAlerta(alertaRequestDTO);
        Integer id = alertaRepository.inserirAlerta(id_caminhao,alerta.getDescricao(),alerta.getTitulo(),alerta.getCategoria());
        alerta.setStatus(true);
        alerta.setId(id.longValue());
        return globalMapper.toAlertaDTO(alerta);
    }

    @Override
    public void finalizarAlerta(@Param("id_alert") Integer id_alerta,@Param("id_caminhao") Integer id_caminhao){
        String cacheKey = "alerta:" + id_caminhao;
        redisTemplate.delete(cacheKey);
        alertaRepository.finalizarAlerta(id_alerta);
    }
}
