package com.epam.client.service;

import com.epam.orderdata.OrderDTO;

import java.util.List;
import java.util.UUID;

/**
 * DESCRIPTION
 *
 * @author Vladislav_Karpeka
 * @version 1.0.0
 */
public interface OrderService {

  OrderDTO getOrder(UUID id);

  List<OrderDTO> getAll();
}
