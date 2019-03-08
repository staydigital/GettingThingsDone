package org.staydigital.gtd.eventstore.service;

import lombok.RequiredArgsConstructor;
import org.axonframework.commandhandling.gateway.CommandGateway;
import org.springframework.stereotype.Service;
import org.staydigital.gtd.aggregates.planingitem.api.commands.ChangePlaningItem;
import org.staydigital.gtd.aggregates.planingitem.api.commands.CreatePlaningItem;
import org.staydigital.gtd.aggregates.planingitem.api.commands.ReviewPlaningItem;

/**
 * Service to routes command to axon
 *
 */
@Service
@RequiredArgsConstructor
public class CommandService {

    private final CommandGateway commandGateway;

    public void sendCreatePlaningItem(final CreatePlaningItem command) {
        commandGateway.send(command);
    }

    public void sendChangePlaningItem(final ChangePlaningItem command) {
        commandGateway.send(command);
    }

    public void sendReviewPlaningItem(final ReviewPlaningItem command) {
        commandGateway.send(command);
    }
}
