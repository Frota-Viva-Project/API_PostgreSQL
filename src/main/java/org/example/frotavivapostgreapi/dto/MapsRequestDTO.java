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
    @NotBlank
    private Integer latitude;
    @NotBlank
    private Integer longitude;
    @NotNull
    private BigInteger capturaLocalizacaoMl;
}
