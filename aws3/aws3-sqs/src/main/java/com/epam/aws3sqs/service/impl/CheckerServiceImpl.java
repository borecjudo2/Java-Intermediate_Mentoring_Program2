package com.epam.aws3sqs.service.impl;

import com.epam.aws3.model.Order;
import com.epam.aws3sqs.service.CheckerService;
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

  @JmsListener(destination = "${activemq.order.sorted.name}")
  @Override
  public void receiveMessage(Order order) {
    System.out.println(order);
  }
}
