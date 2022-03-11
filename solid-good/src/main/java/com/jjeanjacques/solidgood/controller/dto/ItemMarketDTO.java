package com.jjeanjacques.solidgood.controller.dto;

import com.jjeanjacques.solidgood.enums.ItemEnum;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class ItemMarketDTO {

    private ItemEnum item;
    private String action;

}
