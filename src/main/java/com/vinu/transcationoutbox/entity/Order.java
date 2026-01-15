package com.vinu.transcationoutbox.entity;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;
import lombok.Builder;

import java.util.Date;

@Entity
@Table(name = "order_table")
@Getter
@Setter
public class Order {

       @Id
       @GeneratedValue(strategy = GenerationType.IDENTITY)
       private Long id;

       private String name;
       private String customerId;
       private String productType;
       private Integer quantity;
       private Integer price;
       private Date orderDate;

       protected Order() {
       }

       @Builder
       public Order(String name,
                    String customerId,
                    String productType,
                    Integer quantity,
                    Integer price,
                    Date orderDate) {

              this.name = name;
              this.customerId = customerId;
              this.productType = productType;
              this.quantity = quantity;
              this.price = price;
              this.orderDate = orderDate;
       }
}
