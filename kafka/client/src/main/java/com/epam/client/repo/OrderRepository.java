package com.epam.client.repo;

import com.epam.client.model.Order;
import org.springframework.data.repository.CrudRepository;

import java.util.UUID;

/**
 * DESCRIPTION
 *
 * @author Vladislav_Karpeka
 * @version 1.0.0
 */
public interface OrderRepository extends CrudRepository<Order, UUID> {
}
