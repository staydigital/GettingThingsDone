package org.staydigital.gtd.eventstore;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

/**
 * Starter class for EventStore
 *
 * @author Wittmann
 * @since 1.0.0
 */
@SpringBootApplication
public class EventStoreApplication {

    public static void main(String[] args) {
        SpringApplication.run(EventStoreApplication.class, args);
    }

}
