package org.example.frotavivapostgreapi.dto;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import lombok.Getter;
import lombok.Setter;

import java.math.BigInteger;
import java.util.Date;

@Getter
@Setter
public class MapsRequestDTO {
    @NotNull
    private Double latitude;
    @NotNull
    private Double longitude;
    @NotNull
    private BigInteger capturaLocalizacaoMl;
}
