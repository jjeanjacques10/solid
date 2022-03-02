package com.jjeanjacques.solidbad.controller.dto;


import lombok.Builder;
import lombok.Data;

import java.time.LocalDateTime;

@Data
@Builder
public class ReportDTO {

    private Integer total;
    private Integer power;
    private LocalDateTime createdAt;

}
