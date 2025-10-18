package org.example.frotavivapostgreapi.service.impl;

import org.example.frotavivapostgreapi.mapper.GlobalMapper;
import org.example.frotavivapostgreapi.dto.ArduinoResponseDTO;
import org.example.frotavivapostgreapi.repository.ArduinoRepository;
import org.example.frotavivapostgreapi.service.ArduinoService;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.web.bind.annotation.PathVariable;

import java.time.Duration;

public class ArduinoServiceImpl implements ArduinoService {
    private final ArduinoRepository arduinoRepository;

    private RedisTemplate<String, Object> redisTemplate;

    private final GlobalMapper globalMapper;

    public  ArduinoServiceImpl(ArduinoRepository arduinoRepository,
                               RedisTemplate<String, Object> redisTemplate,
                               GlobalMapper globalMapper) {
        this.arduinoRepository = arduinoRepository;
        this.redisTemplate = redisTemplate;
        this.globalMapper = globalMapper;
    }

    @Override
    public ArduinoResponseDTO listById(@PathVariable("id_caminhao") Integer id) {
        String cacheKey = "arduino:" + id;

        Object cache = redisTemplate.opsForValue().get(cacheKey);
        if (cache != null) {
            return (ArduinoResponseDTO) cache;
        }

        ArduinoResponseDTO arduinoResponseDTO = globalMapper.toArduinoDTO(arduinoRepository.findByIdCaminhao(id));
        redisTemplate.opsForValue().set(cacheKey, arduinoResponseDTO, Duration.ofMinutes(10));
        return arduinoResponseDTO;
    }
}
