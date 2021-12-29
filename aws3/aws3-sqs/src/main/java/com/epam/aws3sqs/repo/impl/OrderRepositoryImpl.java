package com.epam.aws3sqs.repo.impl;

import com.amazonaws.services.s3.AmazonS3;
import com.amazonaws.services.s3.model.S3Object;
import com.epam.aws3.model.Order;
import com.epam.aws3sqs.repo.OrderRepository;
import com.fasterxml.jackson.databind.ObjectMapper;
import lombok.AllArgsConstructor;
import lombok.SneakyThrows;
import org.springframework.stereotype.Repository;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

/**
 * DESCRIPTION
 *
 * @author Vladislav_Karpeka
 * @version 1.0.0
 */
@Repository
@AllArgsConstructor
public class OrderRepositoryImpl implements OrderRepository {

  private static final String BUCKET_NAME = "aws3-order";
  private static final String FILE_NAME = "orders.json";

  private final AmazonS3 amazon;
  private final ObjectMapper objectMapper;

  @SneakyThrows
  @Override
  public synchronized void save(Order order) {
    List<Order> orders = getAllOrders();
    orders.add(order);
    String json = objectMapper.writeValueAsString(orders);
    amazon.putObject(BUCKET_NAME, FILE_NAME, json);
  }

  @SneakyThrows
  private List<Order> getAllOrders() {
    S3Object object = amazon.getObject(BUCKET_NAME, FILE_NAME);
    return objectMapper.readValue(object.getObjectContent(), List.class);
  }
}
