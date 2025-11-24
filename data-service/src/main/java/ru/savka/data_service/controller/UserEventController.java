package ru.savka.data_service.controller;

import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RestController;
import ru.savka.data_service.api.EventsApi;
import ru.savka.data_service.data.UserEvent;
import ru.savka.data_service.data.UserEventRepository;

import java.util.List;
import java.util.stream.Collectors;

@RestController
@RequiredArgsConstructor
public class UserEventController implements EventsApi {

    private final UserEventRepository userEventRepository;

    @Override
    public ResponseEntity<List<ru.savka.data_service.model.UserEvent>> eventsGet() {
        List<UserEvent> events = userEventRepository.findAll();
        List<ru.savka.data_service.model.UserEvent> responseEvents = events.stream()
                .map(this::mapToApiResponse)
                .collect(Collectors.toList());
        return ResponseEntity.ok(responseEvents);
    }

    private ru.savka.data_service.model.UserEvent mapToApiResponse(UserEvent userEvent) {
        ru.savka.data_service.model.UserEvent responseEvent = new ru.savka.data_service.model.UserEvent();
        responseEvent.setEventType(userEvent.getEventType());
        responseEvent.setEventTime(userEvent.getEventTime());
        return responseEvent;
    }
}
