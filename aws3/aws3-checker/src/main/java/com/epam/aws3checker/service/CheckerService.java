package com.epam.aws3checker.service;

import com.epam.aws3.model.Order;

/**
 * DESCRIPTION
 *
 * @author Vladislav_Karpeka
 * @version 1.0.0
 */
public interface CheckerService {

  void receiveMessageLiquids(Order order);
  void receiveMessageCountable(Order order);
}
