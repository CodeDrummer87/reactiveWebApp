package com.example.reactiveWebApp.repository;

import com.example.reactiveWebApp.entity.NotificationEntity;
import org.springframework.data.r2dbc.repository.R2dbcRepository;

public interface NotificationRepository extends R2dbcRepository<NotificationEntity, Integer> {
}
