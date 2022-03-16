package com.jjeanjacques.solidbad.controller.dto;

import com.jjeanjacques.solidbad.domain.Pokeball;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class PaymentDTO {

    private List<Pokeball> items;

}
