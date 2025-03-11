package com.hplearn.orderservice.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class OrderDto {

    private Long orderId;
    private String status;
    private String comment;
    private Long userOwnerId;
    private List<Long> itemIds;
}
