package com.vinu.transcationoutbox.repository;

import com.vinu.transcationoutbox.entity.Order;
import org.springframework.data.jpa.repository.JpaRepository;

public interface OrderRepository extends JpaRepository<Order,Long> {

}
