package com.epam.aws3sender.controller;

import com.epam.aws3.model.Order;
import com.epam.aws3sender.service.SenderService;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * DESCRIPTION
 *
 * @author Vladislav_Karpeka
 * @version 1.0.0
 */
@RestController
@RequestMapping("/jms")
public class JmsController {

  private final SenderService service;

  private final String queueName;

  public JmsController(SenderService service, @Value("${activemq.order.init.name}") String queueName) {
    this.service = service;
    this.queueName = queueName;
  }

  @PostMapping
  public void sendMessage(@RequestBody Order order) {
    service.sendMessage(queueName, order);
  }
}
