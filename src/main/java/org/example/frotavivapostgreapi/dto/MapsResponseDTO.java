package org.example.frotavivapostgreapi.dto;

import lombok.Getter;
import lombok.Setter;

import java.math.BigInteger;
import java.util.Date;

@Getter
@Setter
public class MapsResponseDTO {
    private Long id;

    private Double latitude;

    private Double longitude;

    private BigInteger capturaLocalizacaoMl;
}
