package com.hplearn.orderservice.mapper;

import com.hplearn.orderservice.dto.OrderDto;
import com.hplearn.orderservice.entity.Order;
import org.mapstruct.Mapper;
import org.mapstruct.factory.Mappers;

@Mapper
public interface OrderMapper {
    OrderMapper INSTANCE = Mappers.getMapper(OrderMapper.class);

    OrderDto toDto(Order order);
    Order toEntity(OrderDto orderDto);
}
