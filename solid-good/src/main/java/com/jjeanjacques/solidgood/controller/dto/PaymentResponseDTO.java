package com.jjeanjacques.solidgood.controller.dto;

import com.jjeanjacques.solidgood.domain.Pokeball;
import lombok.Builder;
import lombok.Data;

import java.util.List;

@Data
@Builder
public class PaymentResponseDTO {

    private List<Pokeball> items;
    private boolean status;

}
