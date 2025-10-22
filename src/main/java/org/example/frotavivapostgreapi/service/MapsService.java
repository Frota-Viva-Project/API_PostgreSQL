package org.example.frotavivapostgreapi.service;

import org.example.frotavivapostgreapi.dto.MapsRequestDTO;
import org.example.frotavivapostgreapi.dto.MapsResponseDTO;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;

public interface MapsService {

    MapsResponseDTO buscarMaps(@PathVariable Integer id_maps);
    Integer inserirMaps(@RequestBody MapsRequestDTO mapsRequestDTO);
    void atualizarMaps(@PathVariable Integer id_maps, @RequestBody MapsRequestDTO mapsRequestDTO);

}
