package org.staydigital.gtd.aggregates.planingitem;


import org.axonframework.test.aggregate.AggregateTestFixture;
import org.axonframework.test.aggregate.FixtureConfiguration;
import org.junit.Before;
import org.junit.Test;
import org.staydigital.gtd.aggregates.planingitem.api.commands.ChangePlaningItem;
import org.staydigital.gtd.aggregates.planingitem.api.commands.CreatePlaningItem;
import org.staydigital.gtd.aggregates.planingitem.api.commands.ReviewPlaningItem;
import org.staydigital.gtd.aggregates.planingitem.api.events.PlaningItemChangedEvent;
import org.staydigital.gtd.aggregates.planingitem.api.events.PlaningItemCreatedEvent;
import org.staydigital.gtd.aggregates.planingitem.api.events.PlaningItemReviewedEvent;

import java.util.UUID;

public class PlaningItemAggregateTest {

    private FixtureConfiguration<PlaningItemAggregate> fixture;

    private static final UUID ID = UUID.randomUUID();
    private static final String TITLE = "Jenkins build überprüfen";
    private static final String CHANGEDTITLE = "Firmen Jenkins build prüfen";
    private static final String CONTENT = "Irgendwas scheint nicht zu stimmen";
    private static final String CHANGEDCONTENT = "Irgendwas stimmt hier überhaupt nicht";

    @Before
    public void setUp() {
        fixture = new AggregateTestFixture<>(PlaningItemAggregate.class);
        new PlaningItemCreatedEvent(ID, TITLE, CONTENT);
    }

    private PlaningItemCreatedEvent planingItemCreatedEvent() {
        return new PlaningItemCreatedEvent(ID, TITLE, CONTENT);
    }

    @Test
    public void On_CreatePlaningItem_PlaningItemCreatedEvent_ShouldOccure() {
        fixture.givenNoPriorActivity()
                .when(new CreatePlaningItem(ID, TITLE, CONTENT))
                .expectEvents(planingItemCreatedEvent());

    }

    @Test
    public void On_ChangePlaningItem_PlaningItemChangedEvent_ShouldOccure() {
        fixture.given(planingItemCreatedEvent())
                .when(new ChangePlaningItem(ID, CHANGEDTITLE, CHANGEDCONTENT))
                .expectEvents(new PlaningItemChangedEvent(ID, CHANGEDTITLE, CHANGEDCONTENT));
    }

    @Test
    public void On_ReviewItem_PlaningItemReviewedEvent_ShouldOccure() {
        fixture.given(planingItemCreatedEvent())
                .when(new ReviewPlaningItem(ID))
                .expectEvents(new PlaningItemReviewedEvent(ID));
    }

}