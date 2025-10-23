package org.example.frotavivapostgreapi.service.impl;

import org.example.frotavivapostgreapi.dto.MapsRequestDTO;
import org.example.frotavivapostgreapi.dto.MapsResponseDTO;
import org.example.frotavivapostgreapi.mapper.GlobalMapper;
import org.example.frotavivapostgreapi.model.Maps;
import org.example.frotavivapostgreapi.repository.MapsRepository;
import org.example.frotavivapostgreapi.service.MapsService;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;

public class MapsServiceImpl implements MapsService {
    private final MapsRepository mapsRepository;

    private final GlobalMapper globalMapper;

    public MapsServiceImpl(MapsRepository mapsRepository, GlobalMapper globalMapper) {
        this.mapsRepository = mapsRepository;
        this.globalMapper = globalMapper;
    }

    @Override
    public MapsResponseDTO buscarMaps(@PathVariable Integer id_maps) {
        Maps maps = mapsRepository.findById(id_maps);
        return globalMapper.toMapsDTO(maps);
    }

    @Override
    public Integer inserirMaps(@RequestBody MapsRequestDTO mapsRequestDTO) {
        Maps maps = globalMapper.toMaps(mapsRequestDTO);
        return mapsRepository.inserirMaps(maps.getLatitude(), maps.getLongitude(), maps.getCapturaLocalizacaoMl());

    }

    @Override
    public void atualizarMaps(@PathVariable Integer id_maps, @RequestBody MapsRequestDTO mapsRequestDTO) {
        Maps maps = globalMapper.toMaps(mapsRequestDTO);
        mapsRepository.atualizarMaps(id_maps, maps.getLatitude(), maps.getLongitude(), maps.getCapturaLocalizacaoMl());
    }
}
