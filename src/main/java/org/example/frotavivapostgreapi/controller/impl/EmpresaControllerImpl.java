package org.example.frotavivapostgreapi.controller.impl;

import org.example.frotavivapostgreapi.controller.EmpresaController;
import org.example.frotavivapostgreapi.model.Empresa;
import org.example.frotavivapostgreapi.repository.EmpresaRepository;
import org.example.frotavivapostgreapi.service.EmpresaService;
import org.example.frotavivapostgreapi.service.impl.EmpresaServiceImpl;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("v1/api")
public class EmpresaControllerImpl implements EmpresaController {
    private final EmpresaService empresaService;

    public EmpresaControllerImpl(EmpresaRepository empresaRepository) {
        this.empresaService = new EmpresaServiceImpl(empresaRepository);
    }

    @Override
    public ResponseEntity<Empresa> listById(@PathVariable("id_empresa") Integer id_empresa) {
        Empresa empresa = empresaService.listById(id_empresa);
        if (empresa == null) {
            return ResponseEntity.notFound().build();
        }
        return ResponseEntity.ok(empresa);
    }
}
