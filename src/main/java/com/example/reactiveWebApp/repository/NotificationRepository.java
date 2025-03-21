package com.example.reactiveWebApp.repository;

import com.example.reactiveWebApp.entity.Notification;
import org.springframework.data.domain.Pageable;
import org.springframework.data.r2dbc.repository.R2dbcRepository;
import reactor.core.publisher.Flux;

public interface NotificationRepository extends R2dbcRepository<Notification, Integer> {
    Flux<Notification> findAllBy(Pageable pageable);
}
