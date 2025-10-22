package org.example.frotavivapostgreapi.controller.impl;

import jakarta.persistence.EntityNotFoundException;
import org.example.frotavivapostgreapi.controller.MapsController;
import org.example.frotavivapostgreapi.dto.MapsRequestDTO;
import org.example.frotavivapostgreapi.dto.MapsResponseDTO;
import org.example.frotavivapostgreapi.mapper.GlobalMapper;
import org.example.frotavivapostgreapi.repository.MapsRepository;
import org.example.frotavivapostgreapi.service.MapsService;
import org.example.frotavivapostgreapi.service.impl.MapsServiceImpl;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("v1/api")
public class MapsControllerImpl implements MapsController {
    private final MapsService mapsService;

    public MapsControllerImpl(MapsRepository mapsRepository, GlobalMapper globalMapper) {
        this.mapsService = new MapsServiceImpl(mapsRepository, globalMapper);
    }

    @Override
    public ResponseEntity<MapsResponseDTO> buscarMaps(@PathVariable Integer id_maps) {
        MapsResponseDTO maps = mapsService.buscarMaps(id_maps);
        if (maps == null) {
            throw new EntityNotFoundException("Maps não encontrado com o id: "+id_maps);
        }

        return ResponseEntity.ok(maps);
    }

    @Override
    public ResponseEntity<Integer> inserirMaps(@RequestBody MapsRequestDTO mapsRequestDTO) {
        Integer id = mapsService.inserirMaps(mapsRequestDTO);
        return ResponseEntity.ok(id);
    }

    @Override
    public ResponseEntity<HttpStatus> atualizarMaps(@PathVariable Integer id_maps, @RequestBody MapsRequestDTO mapsRequestDTO) {
        mapsService.atualizarMaps(id_maps, mapsRequestDTO);
        return ResponseEntity.ok(HttpStatus.OK);
    }
}
