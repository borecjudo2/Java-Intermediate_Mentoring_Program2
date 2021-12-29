package com.epam.aws3sqs.repo;

import com.epam.aws3.model.Order;

/**
 * DESCRIPTION
 *
 * @author Vladislav_Karpeka
 * @version 1.0.0
 */
public interface OrderRepository {

  void save(Order order);
}
