package com.vinu.transcationoutbox.entity;

import jakarta.persistence.*;
import lombok.Builder;
import lombok.Getter;
import lombok.Setter;

import java.util.Date;


@Getter
@Entity
@Setter
@Table(name="outbox")
public class Outbox {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String aggregateId;
    private String payload;
    private Date createdAt;
    private Boolean processed;

    protected Outbox(){}

    @Builder
    public Outbox(String aggregateId,
                  String payload,
                  Date createdAt,
                  Boolean processed) {

        this.aggregateId = aggregateId;
        this.payload = payload;
        this.createdAt = createdAt;
        this.processed = processed;
    }
}
