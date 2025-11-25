package ru.savka.schedule_service.scheduler;

import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Component;
import org.springframework.web.client.RestTemplate;
import ru.savka.schedule_service.data.UserEvent;

import java.util.Arrays;
import java.util.List;

@Component
public class DataSyncScheduler {

    private final RestTemplate restTemplate;

    public DataSyncScheduler(RestTemplate restTemplate) {
        this.restTemplate = restTemplate;
    }

    @Scheduled(cron = "0/30 * * * * *")
    public void syncData() {
        System.out.println("Запускаем миграцию...");
        // Fetch data from data-service
        UserEvent[] events = restTemplate.getForObject("http://localhost:8083/events", UserEvent[].class);

        if (events != null && events.length > 0) {
            // Send data to report-service
            restTemplate.postForObject("http://localhost:8084/events", Arrays.asList(events), Void.class);
            System.out.println("Успешно отправлено " + events.length + " событий в report-service.");
        } else {
            System.out.println("Нет событий для отправки.");
        }
    }
}
