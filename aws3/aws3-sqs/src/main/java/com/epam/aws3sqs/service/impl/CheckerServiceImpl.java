package com.epam.aws3sqs.service.impl;

import com.epam.aws3.model.Order;
import com.epam.aws3sqs.repo.OrderRepository;
import com.epam.aws3sqs.service.CheckerService;
import lombok.AllArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.jms.annotation.JmsListener;
import org.springframework.stereotype.Service;

/**
 * DESCRIPTION
 *
 * @author Vladislav_Karpeka
 * @version 1.0.0
 */
@Slf4j
@Service
@AllArgsConstructor
public class CheckerServiceImpl implements CheckerService {

  private final OrderRepository orderRepository;

  @JmsListener(destination = "${activemq.order.sorted.name}")
  @Override
  public void receiveMessage(Order order) {
    orderRepository.save(order);
    log.info("Order has been saved: " + order);
  }
}
