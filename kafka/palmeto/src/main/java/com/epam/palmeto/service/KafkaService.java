package com.epam.palmeto.service;

import com.epam.orderdata.OrderDTO;

/**
 * DESCRIPTION
 *
 * @author Vladislav_Karpeka
 * @version 1.0.0
 */
public interface KafkaService {

  void consume(String json);

  void cookPizza(OrderDTO orderDTO);
}
