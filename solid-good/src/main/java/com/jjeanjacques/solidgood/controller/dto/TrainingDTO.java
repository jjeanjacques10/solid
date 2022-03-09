package com.jjeanjacques.solidgood.controller.dto;

import lombok.Builder;
import lombok.Data;

import java.time.LocalDateTime;

@Data
@Builder
public class TrainingDTO {

    private float intension;
    private LocalDateTime date;

}
