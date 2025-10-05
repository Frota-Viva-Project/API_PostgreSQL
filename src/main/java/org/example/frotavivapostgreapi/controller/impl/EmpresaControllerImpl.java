package org.example.frotavivapostgreapi.controller.impl;

import org.example.frotavivapostgreapi.Mapper.GlobalMapper;
import org.example.frotavivapostgreapi.controller.EmpresaController;
import org.example.frotavivapostgreapi.dto.EmpresaResponseDTO;
import org.example.frotavivapostgreapi.model.Empresa;
import org.example.frotavivapostgreapi.repository.EmpresaRepository;
import org.example.frotavivapostgreapi.service.EmpresaService;
import org.example.frotavivapostgreapi.service.impl.EmpresaServiceImpl;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("v1/api")
public class EmpresaControllerImpl implements EmpresaController {
    private final EmpresaService empresaService;

    public EmpresaControllerImpl(EmpresaRepository empresaRepository, RedisTemplate<String, Object> redisTemplate, GlobalMapper globalMapper) {
        this.empresaService = new EmpresaServiceImpl(empresaRepository, redisTemplate, globalMapper);
    }

    @Override
    public ResponseEntity<EmpresaResponseDTO> listById(@PathVariable("id_empresa") Integer id_empresa) {
        EmpresaResponseDTO empresa = empresaService.listById(id_empresa);
        if (empresa == null) {
            return ResponseEntity.notFound().build();
        }
        return ResponseEntity.ok(empresa);
    }
}
