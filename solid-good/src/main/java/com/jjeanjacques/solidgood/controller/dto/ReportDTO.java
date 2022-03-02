package com.jjeanjacques.solidgood.controller.dto;

import com.jjeanjacques.solidgood.repository.dto.PowerTypeContract;
import lombok.Builder;
import lombok.Data;

import java.time.LocalDateTime;
import java.util.List;

@Data
@Builder
public class ReportDTO {

    private Integer total;
    private Integer power;
    private List<PowerTypeContract> categories;
    private LocalDateTime createdAt;

}
