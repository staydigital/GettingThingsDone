package org.staydigital.gtd.aggregates.node;

import org.staydigital.gtd.aggregates.*;

import java.util.UUID;

/**
 * Aggregate for Planing Items. Aggregate should be constructed by Builder.
 * Builder can be obtained by static Builder method.
 *
 * @author Wittmann
 * @since 1.0.0
 */
@Aggregate
class PlaningItemAggregate {

    final UUID id;

    @AggregateRoot
    PlaningItem planingItem;

    @ObjectValue
    DateValue creationDate;

    @Entity
    PlaningContent planingContent;

    private PlaningItemAggregate(final PlaningItemAggregateBuilder builder) {
        this.id = UUID.randomUUID();
        this.planingItem = new PlaningItem(builder.title);
        this.planingContent = new PlaningContent(builder.content);
        this.creationDate = new DateValue();
    }

    static PlaningItemAggregateBuilder builder() {
        return new PlaningItemAggregateBuilder();
    }

    /**
     * Builder for Planing item Aggregate. Mandatory values are title and content.
     *
     * @author Wittmann
     * @since 1.0.0
     */
    @AggregateBuilder
    static class PlaningItemAggregateBuilder {

        private String title;
        private String content;

        PlaningItemAggregate build() {
            return new PlaningItemAggregate(this);
        }

        PlaningItemAggregateBuilder title(final String title) {
            this.title = title;
            return this;
        }

        PlaningItemAggregateBuilder content(final String content) {
            this.content = content;
            return this;
        }

    }

}
