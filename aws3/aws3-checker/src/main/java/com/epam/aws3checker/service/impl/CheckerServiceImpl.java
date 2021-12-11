package com.epam.aws3checker.service.impl;

import com.epam.aws3.model.Order;
import com.epam.aws3checker.service.CheckerService;
import com.epam.aws3checker.service.SenderService;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.jms.annotation.JmsListener;
import org.springframework.stereotype.Service;

/**
 * DESCRIPTION
 *
 * @author Vladislav_Karpeka
 * @version 1.0.0
 */
@Service
public class CheckerServiceImpl implements CheckerService {

  private final String sortedQueueName;
  private final SenderService senderService;

  public CheckerServiceImpl(@Value("${activemq.order.sorted.name}") String sortedQueueName,
      SenderService senderService) {
    this.sortedQueueName = sortedQueueName;
    this.senderService = senderService;
  }

  @JmsListener(destination = "${activemq.order.init.name}", selector = "type = 'liquids'")
  @Override
  public void receiveMessageLiquids(Order order) {
    System.out.println(order);
    senderService.sendMessage(sortedQueueName, checkOrder(order));
  }

  @JmsListener(destination = "${activemq.order.init.name}", selector = "type = 'countable'")
  @Override
  public void receiveMessageCountable(Order order) {
    System.out.println(order);
    senderService.sendMessage(sortedQueueName, checkOrder(order));
  }

  private Order checkOrder(Order order) {
    if (order.getPrice() != null && order.getPrice() > 1000) {
      order.setRejected(true);
    } else if (order.getLiters() != null && order.getLiters() > 3) {
      order.setRejected(true);
    } else {
      order.setRejected(false);
    }
    return order;
  }
}
