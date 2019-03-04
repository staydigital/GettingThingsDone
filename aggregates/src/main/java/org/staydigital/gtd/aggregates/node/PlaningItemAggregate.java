package org.staydigital.gtd.aggregates.node;

import org.apache.commons.lang3.StringUtils;
import org.staydigital.gtd.aggregates.*;

import java.util.UUID;

/**
 * Aggregate for Planing Items. Aggregate should be constructed by Builder.
 * Builder can be obtained by static builder method.
 *
 * @author Wittmann
 * @since 1.0.0
 */
@Aggregate
class PlaningItemAggregate {

    @AggregateRoot
    PlaningItem planingItem;

    @Entity
    PlaningContent planingContent;

    @ObjectValue
    UUID id;

    @ObjectValue
    DateValue creationDate;

    @ObjectValue
    PlaningItemState planingItemState;

    private PlaningItemAggregate(final PlaningItemAggregateBuilder builder) {
        this.id = UUID.randomUUID();
        this.planingItem = new PlaningItem(builder.title);
        this.planingContent = new PlaningContent(builder.content);
        this.creationDate = new DateValue();
        this.planingItemState = PlaningItemState.INITIALIZED;
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

        /**
         * Builds an Planing item Aggregate with supplied values.
         *
         * @throws IllegalArgumentException if title or content is left empty
         * @return New instance of Planing item Aggregate with supplied values
         */
        PlaningItemAggregate build() {
            if (StringUtils.isEmpty(title)) {
                throw new IllegalArgumentException("Title is not set");
            }
            if (StringUtils.isEmpty(content)) {
                throw new IllegalArgumentException("Content is not set");
            }
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
