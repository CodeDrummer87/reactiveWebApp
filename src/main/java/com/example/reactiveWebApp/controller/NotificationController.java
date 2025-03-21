package com.example.reactiveWebApp.controller;

import com.example.reactiveWebApp.entity.Notification;
import com.example.reactiveWebApp.service.NotificationService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

@RestController
@RequestMapping("/api/v1/notifications")
@RequiredArgsConstructor
public class NotificationController {

    private final NotificationService notificationService;

    @GetMapping("/{id}")
    public Mono<Notification> getNotificationById(@PathVariable Integer id) {
        return notificationService.getNotificationById(id);
    }

    @GetMapping("/page/{page}")
    public Flux<Notification> getPageOfNotifications(@PathVariable Integer page) {
        return notificationService.getPageOfNotifications(page);
    }

    @PostMapping
    public Mono<Notification> createNotification(@RequestBody Notification notification) {
        return notificationService.save(notification);
    }

    @PutMapping("/{id}")
    public Mono<Notification> updateNotification(@PathVariable Integer id, String status) {
        return notificationService.updateNotification(id, status);
    }
}
