package com.vinu.transcationoutbox.common.mapper;

import com.vinu.transcationoutbox.entity.Order;
import com.vinu.transcationoutbox.entity.Outbox;
import org.springframework.stereotype.Component;
import tools.jackson.databind.ObjectMapper;

import java.util.Date;
@Component
public class OrderEntityToOutboxEntity {
    public Outbox toOutboxEntity(Order order){
        return Outbox.builder()
            .aggregateId(order.getId().toString())
            .payload((new ObjectMapper().writeValueAsString(order)))
            .createdAt(new Date())
            .processed(false)
            .build();
    }
}
