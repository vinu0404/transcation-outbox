package com.vinu.transcationoutbox.common.mapper;

import com.vinu.transcationoutbox.common.OrderRequestDTO;
import com.vinu.transcationoutbox.entity.Order;
import org.springframework.stereotype.Component;

import java.util.Date;

@Component
public class OrderDTOtoEntityMapper {
    public Order toEntity(OrderRequestDTO orderRequestDTO){
        return Order.builder()
                .customerId(orderRequestDTO.getCustomerId())
                .name(orderRequestDTO.getName())
                .productType((orderRequestDTO.getProductType()))
                .quantity(orderRequestDTO.getQuantity())
                .price(orderRequestDTO.getPrice())
                .orderDate(new Date())
                .build();

    }
}
