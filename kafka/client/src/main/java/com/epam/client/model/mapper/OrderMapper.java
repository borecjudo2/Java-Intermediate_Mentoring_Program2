package com.epam.client.model.mapper;

import com.epam.client.model.Order;
import com.epam.orderdata.OrderDTO;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.factory.Mappers;

/**
 * DESCRIPTION
 *
 * @author Vladislav_Karpeka
 * @version 1.0.0
 */
@Mapper
public interface OrderMapper {

  OrderMapper INSTANCE = Mappers.getMapper(OrderMapper.class);

  @Mapping(target = "id")
  OrderDTO orderToOrderDTO(Order order);

  @Mapping(target = "id")
  Order orderDTOToOrder(OrderDTO orderDTO);

}
