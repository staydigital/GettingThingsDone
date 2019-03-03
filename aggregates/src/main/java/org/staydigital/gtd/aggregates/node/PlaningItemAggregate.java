package org.staydigital.gtd.aggregates.node;

import lombok.Builder;
import org.staydigital.gtd.aggregates.*;

import java.util.UUID;

@Aggregate
public class PlaningItemAggregate {

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

    public static PlaningItemAggregateBuilder builder() {
        return new PlaningItemAggregateBuilder();
    }

    @AggregateBuilder
    static class PlaningItemAggregateBuilder {

        private String title;
        private String content;

        public PlaningItemAggregate build() {
            return new PlaningItemAggregate(this);
        }

        public PlaningItemAggregateBuilder title(final String title) {
            this.title = title;
            return this;
        }

        public PlaningItemAggregateBuilder content(final String content) {
            this.content = content;
            return this;
        }

    }

}
