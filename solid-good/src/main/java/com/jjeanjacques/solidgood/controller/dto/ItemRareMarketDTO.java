package com.jjeanjacques.solidgood.controller.dto;

import com.jjeanjacques.solidgood.enums.ItemRareEnum;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class ItemRareMarketDTO {

    private ItemRareEnum item;
    private String action;

}
