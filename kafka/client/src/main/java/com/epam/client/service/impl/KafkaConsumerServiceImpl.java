package com.epam.client.service.impl;

import com.epam.client.model.Order;
import com.epam.client.model.mapper.OrderMapper;
import com.epam.client.repo.OrderRepository;
import com.epam.client.service.KafkaConsumerService;
import com.epam.orderdata.OrderDTO;
import com.fasterxml.jackson.databind.ObjectMapper;
import lombok.AllArgsConstructor;
import lombok.SneakyThrows;
import lombok.extern.slf4j.Slf4j;
import org.springframework.kafka.annotation.KafkaListener;
import org.springframework.stereotype.Service;

/**
 * DESCRIPTION
 *
 * @author Vladislav_Karpeka
 * @version 1.0.0
 */
@Slf4j
@Service
@AllArgsConstructor
public class KafkaConsumerServiceImpl implements KafkaConsumerService {

  private final ObjectMapper objectMapper;

  private final OrderMapper orderMapper;

  private final OrderRepository repository;

  @SneakyThrows
  @KafkaListener(topics = "${topic.notification.name}", groupId = "${group.id}")
  @Override
  public void consume(String json) {
    OrderDTO orderDTO = objectMapper.readValue(json, OrderDTO.class);
    Order order = orderMapper.orderDTOToOrder(orderDTO);
    Order savedOrder = repository.save(order);
    log.info(savedOrder.getCustomerName() + " order is " + savedOrder.getOrderType());
  }
}
