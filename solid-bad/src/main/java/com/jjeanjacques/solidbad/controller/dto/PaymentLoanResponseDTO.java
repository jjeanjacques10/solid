package com.jjeanjacques.solidbad.controller.dto;

import com.jjeanjacques.solidbad.domain.Pokeball;
import lombok.Builder;
import lombok.Data;

import java.util.List;

@Data
@Builder
public class PaymentLoanResponseDTO {

    private List<Pokeball> items;
    private boolean status;
}
