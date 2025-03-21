package com.example.reactiveWebApp.service;

import com.example.reactiveWebApp.entity.Notification;
import com.example.reactiveWebApp.repository.NotificationRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

@Service
@RequiredArgsConstructor
public class NotificationService {

    private final NotificationRepository notificationRepository;

    public Mono<Notification> getNotificationById(Integer id) {
        return notificationRepository.findById(id)
                .switchIfEmpty(Mono.error(new IllegalStateException("No notification found with id: " + id)));
    }

    public Flux<Notification> findAll() {   // + pagination
        return notificationRepository.findAll();
    }

    /*
    public Mono<PageSupport<Entity>> getEntityPage(Pageable page) {
    return repository.findAll()
        .collectList()
        .map(list -> new PageSupport<>(
            list
                .stream()
                .skip(page.getPageNumber() * page.getPageSize())
                .limit(page.getPageSize())
                .collect(Collectors.toList()),
            page.getPageNumber(), page.getPageSize(), list.size()));
  }*/

    public Mono<Notification> save(Notification notification) {
        return notificationRepository.save(notification);
    }

    public Mono<Notification> updateNotification(Integer id, String status) {
        return notificationRepository.findById(id)
                .flatMap(note -> {
                   note.setNotificationStatus(status);
                   return notificationRepository.save(note);
                })
                .switchIfEmpty(Mono.error(new IllegalStateException("No notification found with id: " + id)));
    }
}
