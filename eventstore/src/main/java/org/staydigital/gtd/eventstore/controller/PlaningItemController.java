package org.staydigital.gtd.eventstore.controller;

import io.netty.handler.codec.http.HttpResponse;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;
import org.staydigital.gtd.aggregates.planingitem.api.commands.CreatePlaningItem;
import org.staydigital.gtd.eventstore.service.CommandService;

import java.util.UUID;

/**
 * Rest Controller for handling commands for Planing Items
 *
 * @author Wittmann
 * @since 1.0.0
 */
@RestController
@RequiredArgsConstructor
public class PlaningItemController {

    private final CommandService commandService;

    @Data
    @NoArgsConstructor
    static class CreatePlaningItemRequest {
        private String title;
        private String content;
    }

    @PostMapping(value = "/create", consumes = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<?> createPlaningItem(@RequestBody final CreatePlaningItemRequest request) {
        CreatePlaningItem command = new CreatePlaningItem(UUID.randomUUID(), request.getTitle(), request.getContent());
        commandService.sendCreatePlaningItem(command);
        return new ResponseEntity<>(command.getId(), HttpStatus.CREATED);
    }
}
