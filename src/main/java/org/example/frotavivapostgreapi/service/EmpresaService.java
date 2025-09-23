package org.example.frotavivapostgreapi.service;

import org.example.frotavivapostgreapi.model.Empresa;
import org.springframework.web.bind.annotation.PathVariable;

public interface EmpresaService {

    Empresa listById(@PathVariable("id_empresa") Integer id_empresa);
}
