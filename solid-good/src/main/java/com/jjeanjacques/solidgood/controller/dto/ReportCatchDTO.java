package com.jjeanjacques.solidgood.controller.dto;

import lombok.Builder;
import lombok.Data;

import java.time.LocalDateTime;
import java.util.List;

@Data
@Builder
public class ReportCatchDTO {

    private int total;
    private LocalDateTime createdAt;
    private List<PokemonDTO> pokemon;

}
