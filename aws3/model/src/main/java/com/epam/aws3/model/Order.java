package com.epam.aws3.model;

import java.util.Objects;
import java.util.UUID;

/**
 * DESCRIPTION
 *
 * @author Vladislav_Karpeka
 * @version 1.0.0
 */
public class Order {

  private UUID id;

  private String name;

  private Integer price;

  private boolean isLiquids;

  private Integer liters;

  private Integer weight;

  private boolean rejected;

  public Order() {
  }

  public Order(UUID id, String name, Integer price, boolean isLiquids, Integer liters, Integer weight, boolean rejected) {
    this.id = id;
    this.name = name;
    this.price = price;
    this.isLiquids = isLiquids;
    this.liters = liters;
    this.weight = weight;
    this.rejected = rejected;
  }

  public UUID getId() {
    return id;
  }

  public void setId(UUID id) {
    this.id = id;
  }

  public String getName() {
    return name;
  }

  public void setName(String name) {
    this.name = name;
  }

  public boolean isLiquids() {
    return isLiquids;
  }

  public void setLiquids(boolean liquids) {
    isLiquids = liquids;
  }

  public Integer getLiters() {
    return liters;
  }

  public void setLiters(Integer liters) {
    this.liters = liters;
  }

  public Integer getWeight() {
    return weight;
  }

  public void setWeight(Integer weight) {
    this.weight = weight;
  }

  public boolean isRejected() {
    return rejected;
  }

  public void setRejected(boolean rejected) {
    this.rejected = rejected;
  }

  public Integer getPrice() {
    return price;
  }

  public void setPrice(Integer price) {
    this.price = price;
  }

  @Override
  public boolean equals(Object o) {
    if (this == o) {
      return true;
    }
    if (o == null || getClass() != o.getClass()) {
      return false;
    }
    Order order = (Order) o;
    return isLiquids == order.isLiquids && rejected == order.rejected && Objects.equals(id, order.id) && Objects.equals(name, order.name) && Objects.equals(price, order.price) && Objects.equals(liters, order.liters) && Objects.equals(weight, order.weight);
  }

  @Override
  public int hashCode() {
    return Objects.hash(id, name, price, isLiquids, liters, weight, rejected);
  }

  @Override
  public String toString() {
    return "Order{" +
        "id=" + id +
        ", name='" + name + '\'' +
        ", price=" + price +
        ", isLiquids=" + isLiquids +
        ", liters=" + liters +
        ", weight=" + weight +
        ", rejected=" + rejected +
        '}';
  }
}
