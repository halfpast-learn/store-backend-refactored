package com.hplearn.orderservice.service;

import com.hplearn.orderservice.dto.OrderDto;
import com.hplearn.orderservice.mapper.OrderMapper;
import com.hplearn.orderservice.repository.OrderRepository;

import jakarta.persistence.EntityNotFoundException;
import lombok.RequiredArgsConstructor;
import lombok.val;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
@RequiredArgsConstructor
public class OrderServiceImpl implements OrderService {

    private final OrderRepository orderRepository;
    private final OrderMapper orderMapper = OrderMapper.INSTANCE;

    @Override
    public OrderDto createOrder(OrderDto orderDto) {
        val order = orderMapper.toEntity(orderDto);
        val savedOrder = orderRepository.save(order);
        return orderMapper.toDto(savedOrder);
    }

    @Override
    public List<OrderDto> getAllOrders() {
        val orders = orderRepository.findAll();
        return orders.stream()
                .map(orderMapper::toDto)
                .collect(Collectors.toList());
    }

    @Override
    public OrderDto getOrderById(Long id) {
        val order = orderRepository.findById(id)
                .orElseThrow(() -> new EntityNotFoundException("Order not found with id: " + id));
        return orderMapper.toDto(order);
    }
}
