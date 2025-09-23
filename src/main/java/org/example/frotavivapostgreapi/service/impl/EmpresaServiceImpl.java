package org.example.frotavivapostgreapi.service.impl;

import org.example.frotavivapostgreapi.model.Empresa;
import org.example.frotavivapostgreapi.repository.EmpresaRepository;
import org.example.frotavivapostgreapi.repository.ManutencaoRepository;
import org.example.frotavivapostgreapi.service.EmpresaService;
import org.springframework.web.bind.annotation.PathVariable;

public class EmpresaServiceImpl implements EmpresaService {
    private final EmpresaRepository empresaRepository;

    public EmpresaServiceImpl(EmpresaRepository empresaRepository) {
        this.empresaRepository = empresaRepository;
    }

    @Override
    public Empresa listById(@PathVariable("id_empresa") Integer id_empresa) {
        return empresaRepository.findById(id_empresa);
    }
}
