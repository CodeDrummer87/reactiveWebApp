package com.example.reactiveWebApp.repository;

import com.example.reactiveWebApp.entity.Notification;
import org.springframework.data.r2dbc.repository.R2dbcRepository;

public interface NotificationRepository extends R2dbcRepository<Notification, Integer> {
}
