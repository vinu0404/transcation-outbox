package com.vinu.transcationoutbox.common;

import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Getter;

@Getter
public class OrderRequestDTO {

    private final String name;
    private final String customerId;
    private final String productType;
    private final Integer quantity;
    private final Integer price;

    @JsonCreator
    public OrderRequestDTO(
            @JsonProperty("name") String name,
            @JsonProperty("customerId") String customerId,
            @JsonProperty("productType") String productType,
            @JsonProperty("quantity") Integer quantity,
            @JsonProperty("price") Integer price
    ) {
        this.name = name;
        this.customerId = customerId;
        this.productType = productType;
        this.quantity = quantity;
        this.price = price;
    }
}
