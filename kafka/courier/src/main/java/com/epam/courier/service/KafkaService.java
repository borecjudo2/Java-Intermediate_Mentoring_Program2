package com.epam.courier.service;

import com.epam.orderdata.OrderDTO;

/**
 * DESCRIPTION
 *
 * @author Vladislav_Karpeka
 * @version 1.0.0
 */
public interface KafkaService {

  void consume(String json);

  void deliveryOrder(OrderDTO orderDTO);
}
