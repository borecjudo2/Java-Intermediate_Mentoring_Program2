package com.epam.aws3sender.service;

import com.epam.aws3.model.Order;

/**
 * DESCRIPTION
 *
 * @author Vladislav_Karpeka
 * @version 1.0.0
 */
public interface SenderService {

  void sendMessage(String queueName, Order order);
}
