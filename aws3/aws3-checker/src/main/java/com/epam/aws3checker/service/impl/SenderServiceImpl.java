package com.epam.aws3checker.service.impl;

import com.epam.aws3.model.Order;
import com.epam.aws3checker.service.SenderService;
import lombok.AllArgsConstructor;
import org.springframework.jms.core.JmsTemplate;
import org.springframework.stereotype.Service;

import java.util.UUID;

/**
 * DESCRIPTION
 *
 * @author Vladislav_Karpeka
 * @version 1.0.0
 */
@Service
@AllArgsConstructor
public class SenderServiceImpl implements SenderService {

  private final JmsTemplate jmsTemplate;

  @Override
  public void sendMessage(String queueName, Order order) {
    order.setId(UUID.randomUUID());
    jmsTemplate.convertAndSend(queueName, order);
  }
}
