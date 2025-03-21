package com.example.reactiveWebApp.service;

import com.example.reactiveWebApp.entity.Notification;
import com.example.reactiveWebApp.repository.NotificationRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

@Service
@RequiredArgsConstructor
public class NotificationService {


    private Integer numberOfEntriesPerPage = 5;
    private final NotificationRepository notificationRepository;

    public Mono<Notification> getNotificationById(Integer id) {
        return notificationRepository.findById(id)
                .switchIfEmpty(Mono.error(new IllegalStateException("No notification found with id: " + id)));
    }

    public Flux<Notification> getPageOfNotifications(int page) {
        Pageable pageable = PageRequest.of(page, numberOfEntriesPerPage);
        return notificationRepository.findAllBy(pageable);
    }

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
