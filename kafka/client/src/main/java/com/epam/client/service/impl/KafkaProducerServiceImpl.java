package com.epam.client.service.impl;

import com.epam.client.model.Order;
import com.epam.client.model.mapper.OrderMapper;
import com.epam.client.repo.OrderRepository;
import com.epam.client.service.KafkaProducerService;
import com.epam.orderdata.OrderDTO;
import com.epam.orderdata.OrderType;
import com.fasterxml.jackson.databind.ObjectMapper;
import lombok.NonNull;
import lombok.RequiredArgsConstructor;
import lombok.SneakyThrows;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.kafka.core.KafkaTemplate;
import org.springframework.stereotype.Service;

/**
 * DESCRIPTION
 *
 * @author Vladislav_Karpeka
 * @version 1.0.0
 */
@Service
@Slf4j
@RequiredArgsConstructor
public class KafkaProducerServiceImpl implements KafkaProducerService {

  @Value("${topic.order.name}")
  private String topic;

  @NonNull
  private final KafkaTemplate kafkaTemplate;

  @NonNull
  private final OrderRepository repository;

  @NonNull
  private final OrderMapper orderMapper;

  @NonNull
  private final ObjectMapper objectMapper;

  @Override
  public OrderDTO takeOrder(OrderDTO orderDTO) {
    orderDTO.setOrderType(OrderType.START_COOKING);
    OrderDTO savedOrderDTO = save(orderDTO);
    kafkaTemplate.send(topic, dtoToJson(savedOrderDTO));
    log.info("--- START_COOKING ---");
    return savedOrderDTO;
  }

  private OrderDTO save(OrderDTO orderDTO) {
    Order order = orderMapper.orderDTOToOrder(orderDTO);
    Order savedOrder = repository.save(order);
    return orderMapper.orderToOrderDTO(savedOrder);
  }

  @SneakyThrows
  private String dtoToJson(OrderDTO orderDTO) {
    return objectMapper.writeValueAsString(orderDTO);
  }
}
