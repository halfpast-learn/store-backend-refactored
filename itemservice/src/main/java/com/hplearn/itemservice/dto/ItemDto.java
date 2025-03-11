package com.hplearn.itemservice.dto;

import lombok.Data;
import java.util.List;

@Data
public class ItemDto {

    private Long itemId;
    private String description;
    private Double price;
    private List<Long> tagIds;
}
