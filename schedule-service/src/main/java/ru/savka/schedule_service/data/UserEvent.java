package ru.savka.schedule_service.data;

import lombok.Getter;
import lombok.Setter;

import java.time.OffsetDateTime;

@Getter
@Setter
public class UserEvent {
    private Long id;
    private String eventType;
    private OffsetDateTime eventTime;
}
