package com.epam.palmeto.service.impl;

import com.epam.orderdata.OrderDTO;
import com.epam.orderdata.OrderType;
import com.epam.palmeto.service.KafkaService;
import com.fasterxml.jackson.databind.ObjectMapper;
import lombok.NonNull;
import lombok.RequiredArgsConstructor;
import lombok.SneakyThrows;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.kafka.annotation.KafkaListener;
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
public class KafkaServiceImpl implements KafkaService {

  @Value("${topic.notification.name}")
  private String topic;

  @NonNull
  private final ObjectMapper objectMapper;

  @NonNull
  private final KafkaTemplate kafkaTemplate;

  @SneakyThrows
  @KafkaListener(topics = "${topic.order.name}", groupId = "${group.id}")
  @Override
  public void consume(String json) {
    OrderDTO orderDTO = objectMapper.readValue(json, OrderDTO.class);
    cookPizza(orderDTO);
    log.info("--- PIZZA_IS_READY ---");
  }

  @Override
  public void cookPizza(OrderDTO orderDTO) {
    orderDTO.setOrderType(OrderType.PIZZA_IS_READY);
    kafkaTemplate.send(topic, dtoToJson(orderDTO));
  }

  @SneakyThrows
  private String dtoToJson(OrderDTO orderDTO) {
    return objectMapper.writeValueAsString(orderDTO);
  }
}
