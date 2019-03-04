package org.staydigital.gtd.aggregates.node;

import java.util.UUID;

/**
 * Aggregate Root for a Planing item. Identified by an id, holds
 * title of Planing item.
 *
 * @author Wittmann
 * @since 1.0.0
 */
class PlaningItem {

    private UUID id;

    private String title;

    PlaningItem(final String title) {
        this.id = UUID.randomUUID();
        this.title = title;
    }
}
