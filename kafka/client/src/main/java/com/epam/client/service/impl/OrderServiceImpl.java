package com.epam.client.service.impl;

import com.epam.client.model.Order;
import com.epam.client.model.mapper.OrderMapper;
import com.epam.client.repo.OrderRepository;
import com.epam.client.service.OrderService;
import com.epam.orderdata.OrderDTO;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.UUID;

/**
 * DESCRIPTION
 *
 * @author Vladislav_Karpeka
 * @version 1.0.0
 */
@Service
@AllArgsConstructor
public class OrderServiceImpl implements OrderService {

  private final OrderRepository orderRepository;

  private final OrderMapper orderMapper;

  @Override
  public OrderDTO getOrder(UUID id) {
    Order order = orderRepository.findById(id).orElseThrow(RuntimeException::new);
    return orderMapper.orderToOrderDTO(order);
  }

  @Override
  public List<OrderDTO> getAll() {
    List<OrderDTO> orderDTOS = new ArrayList<>();
    orderRepository.findAll().forEach(order -> orderDTOS.add(orderMapper.orderToOrderDTO(order)));
    return orderDTOS;
  }
}
