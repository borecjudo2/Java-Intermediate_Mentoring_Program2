package com.epam.orderdata;

import java.util.UUID;

/**
 * DESCRIPTION
 *
 * @author Vladislav_Karpeka
 * @version 1.0.0
 */
public class OrderDTO {

  private UUID id;

  private String customerName;

  private String pizza;

  private OrderType orderType;

  public OrderDTO() {
  }

  public OrderDTO(UUID id, String customerName, String pizza, OrderType orderType) {
    this.id = id;
    this.customerName = customerName;
    this.pizza = pizza;
    this.orderType = orderType;
  }

  public UUID getId() {
    return id;
  }

  public void setId(UUID id) {
    this.id = id;
  }

  public String getCustomerName() {
    return customerName;
  }

  public void setCustomerName(String customerName) {
    this.customerName = customerName;
  }

  public String getPizza() {
    return pizza;
  }

  public void setPizza(String pizza) {
    this.pizza = pizza;
  }

  public OrderType getOrderType() {
    return orderType;
  }

  public void setOrderType(OrderType orderType) {
    this.orderType = orderType;
  }
}
