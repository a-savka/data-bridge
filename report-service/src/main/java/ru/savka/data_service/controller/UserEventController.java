package ru.savka.data_service.controller;

import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RestController;
import ru.savka.data_service.api.EventsApi;
import ru.savka.data_service.dao.UserEventDAO;
import ru.savka.data_service.model.UserEvent;

import java.util.List;

@RestController
@RequiredArgsConstructor
public class UserEventController implements EventsApi {

    private final UserEventDAO userEventDAO;

    @Override
    public ResponseEntity<Object> eventsPost(List<UserEvent> userEvent) {
        userEventDAO.insertUserEvents(userEvent);
        return new ResponseEntity<>(HttpStatus.CREATED);
    }
}