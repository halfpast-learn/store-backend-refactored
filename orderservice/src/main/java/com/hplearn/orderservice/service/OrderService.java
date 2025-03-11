package com.hplearn.orderservice.service;

import com.hplearn.orderservice.dto.OrderDto;

import java.util.List;

public interface OrderService {

    OrderDto createOrder(OrderDto orderDto);

    List<OrderDto> getAllOrders();

    OrderDto getOrderById(Long id);
}
