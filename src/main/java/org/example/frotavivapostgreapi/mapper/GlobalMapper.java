package org.example.frotavivapostgreapi.mapper;

import org.example.frotavivapostgreapi.dto.*;
import org.example.frotavivapostgreapi.model.*;
import org.mapstruct.Builder;
import org.mapstruct.Mapper;

@Mapper(builder = @Builder(disableBuilder = true), componentModel = "spring")
public interface GlobalMapper {
    CaminhaoResponseDTO toCaminhaoDTO(Caminhao caminhao);

    Caminhao toCaminhao(CaminhaoResponseDTO dto);

    Caminhao toCaminhao(CaminhaoRequestDTO dto);

    MotoristaResponseDTO toMotoristaDTO(Motorista motorista);

    Motorista toMotorista(MotoristaResponseDTO dto);

    ArduinoResponseDTO toArduinoDTO(Arduino arduino);

    Arduino toArduino(ArduinoResponseDTO dto);

    ManutencaoResponseDTO toManutencaoDTO(Manutencao manutencao);

    Manutencao toManutencao(ManutencaoResponseDTO dto);

    Manutencao toManutencao(ManutencaoRequestDTO dto);

    RotaCaminhaoResponseDTO toRotaCaminhaoDTO(RotaCaminhao rotaCaminhao);

    RotaCaminhao toRotaCaminhao(RotaCaminhaoRequestDTO caminhaoRequestDTO);

    RotaCaminhao toRotaCaminhao(RotaCaminhaoResponseDTO dto);

    AlertaResponseDTO toAlertaDTO(Alerta alerta);

    Alerta toAlerta(AlertaResponseDTO dto);

    Alerta toAlerta(AlertaRequestDTO dto);

    EmpresaResponseDTO toEmpresaDTO(Empresa empresa);

    Empresa toEmpresa(EmpresaResponseDTO dto);

    Empresa toEmpresa(EmpresaRequestDTO dto);

    ServicoResponseDTO toServicoDTO(Servico servico);

    Servico toServico(ServicoResponseDTO dto);
}
