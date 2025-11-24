package ru.savka.data_service.data;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

import java.time.OffsetDateTime;

@Getter
@Setter
@Entity
@Table(name = "userevent", schema = "utmn")
public class UserEvent {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id", nullable = false)
    private Long id;

    @Column(name = "event_type")
    private String eventType;

    @Column(name = "event_time")
    private OffsetDateTime eventTime;
}
