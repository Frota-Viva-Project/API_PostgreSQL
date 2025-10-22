package org.example.frotavivapostgreapi.controller;

import org.example.frotavivapostgreapi.dto.MapsRequestDTO;
import org.example.frotavivapostgreapi.dto.MapsResponseDTO;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

public interface MapsController {
    @GetMapping("/maps/{id_maps}")
    ResponseEntity<MapsResponseDTO> buscarMaps(@PathVariable Integer id_maps);
    @PostMapping("/maps")
    ResponseEntity<Integer> inserirMaps(@RequestBody MapsRequestDTO mapsRequestDTO);
    @PutMapping("/maps/{id_maps}")
    ResponseEntity<HttpStatus> atualizarMaps(@PathVariable Integer id_maps, @RequestBody MapsRequestDTO mapsRequestDTO);
}
