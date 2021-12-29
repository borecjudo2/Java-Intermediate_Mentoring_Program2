package com.epam.aws3sender.service.impl;

import com.epam.aws3.model.Order;
import com.epam.aws3sender.service.SenderService;
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

    if(order.getLiters() != null) {
      order.setLiquids(true);
      jmsTemplate.convertAndSend(queueName, order, message -> {
        message.setStringProperty("type","liquids");
        return message;
      });
    } else {
      order.setLiquids(false);
      jmsTemplate.convertAndSend(queueName, order, message -> {
        message.setStringProperty("type","countable");
        return message;
      });
    }
  }
}
