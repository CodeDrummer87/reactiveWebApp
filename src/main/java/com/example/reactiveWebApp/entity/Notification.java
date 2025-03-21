package com.example.reactiveWebApp.entity;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.data.annotation.Id;
import org.springframework.data.relational.core.mapping.Column;
import org.springframework.data.relational.core.mapping.Table;

import java.time.LocalDateTime;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder(toBuilder = true)
@Table(name="notifications")
public class Notification {

    @Id
    private Integer id;
    @Column("created_at")
    private LocalDateTime createdAt;
    @Column("modified_at")
    private LocalDateTime modifiedAt;
    @Column("expiration_date")
    private LocalDateTime expirationDate;
    @Column("message")
    private String message;
    @Column("message_type")
    private String messageType;
    @Column("user_uid")
    private String userUid;
    @Column("notification_status")
    private String notificationStatus;

}

