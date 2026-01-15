package com.vinu.transcationoutbox.repository;

import com.vinu.transcationoutbox.entity.Outbox;
import org.springframework.data.jpa.repository.JpaRepository;

public interface OutboxRepository extends JpaRepository<Outbox,Long> {

}
