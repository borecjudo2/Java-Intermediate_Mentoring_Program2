package com.epam.client.service;

import com.epam.orderdata.OrderDTO;

/**
 * DESCRIPTION
 *
 * @author Vladislav_Karpeka
 * @version 1.0.0
 */
public interface KafkaProducerService {

  OrderDTO takeOrder(OrderDTO order);
}
