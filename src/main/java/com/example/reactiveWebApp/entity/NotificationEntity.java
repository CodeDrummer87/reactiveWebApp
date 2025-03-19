package com.example.reactiveWebApp.entity;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.data.annotation.Id;
import org.springframework.data.domain.Persistable;
import org.springframework.data.relational.core.mapping.Table;

import java.time.LocalDateTime;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder(toBuilder = true)
@Table(name="notifications")
public class NotificationEntity implements Persistable<Integer> {

    @Id
    private Integer id;
    private LocalDateTime created_at;
    private LocalDateTime modified_at;
    private LocalDateTime expiration_date;
    private String message;
    private String message_type;
    private String user_uuid;
    private String notification_status;

    @Override
    public boolean isNew() {
        return false;
    }
}

