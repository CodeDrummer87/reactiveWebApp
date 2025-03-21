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

    @GetMapping
    public Flux<Notification> getAllNotifications() {   //.:: add pagination
        return notificationService.findAll();
    }

    /*
    @GetMapping("/entities")
    public Mono<PageSupport<Entity>> getEntitiesPage(
      @RequestParam(name = "page", defaultValue = FIRST_PAGE_NUM) int page,
      @RequestParam(name = "size", defaultValue = DEFAULT_PAGE_SIZE) int size
  ) {

    return service.getEntityPage(PageRequest.of(page, size));
  }*/

    @PostMapping
    public Mono<Notification> createNotification(@RequestBody Notification notification) {
        return notificationService.save(notification);
    }

    @PutMapping("/{id}")
    public Mono<Notification> updateNotification(@PathVariable Integer id, String status) {
        return notificationService.updateNotification(id, status);
    }
}
