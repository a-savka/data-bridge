package ru.savka.data_service.dao;

import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;
import ru.savka.data_service.model.UserEvent;

import java.sql.PreparedStatement;
import java.sql.Timestamp;
import java.util.List;
import java.util.UUID;

@Repository
public class UserEventDAO {

    private final JdbcTemplate jdbcTemplate;

    public UserEventDAO(JdbcTemplate jdbcTemplate) {
        this.jdbcTemplate = jdbcTemplate;
    }

    public void insertUserEvents(List<UserEvent> userEvents) {
        String sql = "INSERT INTO db.user_events (id, event_type, event_time, event_date) VALUES (?, ?, ?, ?)";

        jdbcTemplate.batchUpdate(sql, userEvents, 100, (PreparedStatement ps, UserEvent userEvent) -> {
            ps.setLong(1, Math.abs(UUID.randomUUID().getMostSignificantBits()));
            ps.setString(2, userEvent.getEventType());
            ps.setTimestamp(3, Timestamp.from(userEvent.getEventTime().toInstant()));
            ps.setDate(4, new java.sql.Date(userEvent.getEventTime().toInstant().toEpochMilli()));
        });
    }
}
