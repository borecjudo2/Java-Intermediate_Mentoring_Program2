package com.epam.client.controller;

import com.epam.client.service.KafkaProducerService;
import com.epam.client.service.OrderService;
import com.epam.orderdata.OrderDTO;
import lombok.AllArgsConstructor;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;
import java.util.UUID;

/**
 * DESCRIPTION
 *
 * @author Vladislav_Karpeka
 * @version 1.0.0
 */
@RestController
@RequestMapping("/orders")
@AllArgsConstructor
public class OrderController {

  private final KafkaProducerService kafkaProducerService;

  private final OrderService orderService;

  @PostMapping
  public OrderDTO takeOrder(@RequestBody OrderDTO order) {
    return kafkaProducerService.takeOrder(order);
  }

  @GetMapping("/{id}")
  public OrderDTO getById(@PathVariable("id") UUID id) {
    return orderService.getOrder(id);
  }

  @GetMapping
  public List<OrderDTO> getAll() {
    return orderService.getAll();
  }
}
