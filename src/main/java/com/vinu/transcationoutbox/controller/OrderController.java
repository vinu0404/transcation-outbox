package com.vinu.transcationoutbox.controller;

import com.vinu.transcationoutbox.common.OrderRequestDTO;
import com.vinu.transcationoutbox.entity.Order;
import com.vinu.transcationoutbox.service.OrderService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/orders")
public class OrderController {

    private final OrderService service;

    public OrderController(OrderService service){
        this.service=service;
    }

    @PostMapping
    public ResponseEntity<Order> createOrder(@RequestBody  OrderRequestDTO orderRequestDTO){
        Order order = service.createOrder(orderRequestDTO);
        return ResponseEntity.status(HttpStatus.CREATED).body(order);

    }
}

