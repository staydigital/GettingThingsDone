package org.staydigital.gtd.aggregates.planingitem;

import org.axonframework.commandhandling.CommandHandler;
import org.axonframework.eventhandling.Timestamp;
import org.axonframework.eventsourcing.EventSourcingHandler;
import org.axonframework.modelling.command.AggregateIdentifier;
import org.axonframework.spring.stereotype.Aggregate;
import org.staydigital.gtd.aggregates.planingitem.api.commands.ChangePlaningItem;
import org.staydigital.gtd.aggregates.planingitem.api.commands.CreatePlaningItem;
import org.staydigital.gtd.aggregates.planingitem.api.commands.ReviewPlaningItem;
import org.staydigital.gtd.aggregates.planingitem.api.events.PlaningItemChangedEvent;
import org.staydigital.gtd.aggregates.planingitem.api.events.PlaningItemCreatedEvent;
import org.staydigital.gtd.aggregates.planingitem.api.events.PlaningItemReviewedEvent;

import java.time.Instant;
import java.util.UUID;

import static org.axonframework.modelling.command.AggregateLifecycle.apply;

/**
 * Aggregate for Planing Items.
 * Title and content are modifiable as long as Planing Item is not reviewed.
 * If Planing Item is Reviewed a Reviewed Item is created.
 *
 * @author Wittmann
 * @since 1.0.0
 */
@Aggregate
class PlaningItemAggregate {

    @AggregateIdentifier
    private UUID planingItemId;

    private String title;

    private String content;

    private Instant creationDate;

    private PlaningItemState planingItemState;

    protected PlaningItemAggregate() { }

    @CommandHandler
    public PlaningItemAggregate(final CreatePlaningItem command) {
        apply(new PlaningItemCreatedEvent(command.getId(), command.getTitle(), command.getContent()));
    }

    @EventSourcingHandler
    public void on(final PlaningItemCreatedEvent event, @Timestamp final Instant timestamp) {
        this.planingItemId = event.getId();
        this.title = event.getTitle();
        this.content = event.getContent();
        this.creationDate = timestamp;
        this.planingItemState = PlaningItemState.INITIALIZED;
    }

    @CommandHandler
    public void handle(final ChangePlaningItem command) {
        apply(new PlaningItemChangedEvent(command.getId(), command.getTitle(), command.getContent()));
    }

    @EventSourcingHandler
    public void on(final PlaningItemChangedEvent event) {
        this.title = event.getTitle();
        this.content = event.getContent();
    }

    @CommandHandler
    public void handle(final ReviewPlaningItem command) {
        apply(new PlaningItemReviewedEvent(command.getId()));
    }

    @EventSourcingHandler
    public void on(final PlaningItemReviewedEvent event) {
        this.planingItemState = PlaningItemState.REVIEWED;
    }

}
