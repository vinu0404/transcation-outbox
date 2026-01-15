package com.vinu.transcationoutbox.service;


import com.vinu.transcationoutbox.common.OrderRequestDTO;
import com.vinu.transcationoutbox.common.mapper.OrderDTOtoEntityMapper;
import com.vinu.transcationoutbox.common.mapper.OrderEntityToOutboxEntity;
import com.vinu.transcationoutbox.entity.Order;
import com.vinu.transcationoutbox.entity.Outbox;
import com.vinu.transcationoutbox.repository.OrderRepository;
import com.vinu.transcationoutbox.repository.OutboxRepository;
import jakarta.transaction.Transactional;
import org.springframework.stereotype.Service;

@Service
public class OrderService {

    private final OrderDTOtoEntityMapper map;
    private final OrderEntityToOutboxEntity outboxMap;
    private final OrderRepository orderRepository;
    private final OutboxRepository outboxRepository;

    public OrderService(OrderDTOtoEntityMapper map, OrderRepository orderRepository
            , OrderEntityToOutboxEntity outboxMap, OutboxRepository outboxRepository){
        this.map=map;
        this.orderRepository=orderRepository;
        this.outboxRepository=outboxRepository;
        this.outboxMap=outboxMap;
    }

    @Transactional
    public Order createOrder(OrderRequestDTO orderRequestDTO){
        Order orderEntity = map.toEntity(orderRequestDTO);
        orderRepository.save(orderEntity);
//        System.out.println(10/0);
        Outbox outboxEntity = outboxMap.toOutboxEntity(orderEntity);
        outboxRepository.save(outboxEntity);
        return orderEntity;
    }

}
