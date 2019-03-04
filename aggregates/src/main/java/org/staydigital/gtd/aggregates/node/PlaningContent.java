package org.staydigital.gtd.aggregates.node;

import java.util.UUID;

/**
 * Entity for the Content of a Planing item. Holds Content.
 *
 * @author Wittmann
 * @since 1.0.0
 */
class PlaningContent {

    private UUID id;
    private String content;

    PlaningContent(final String content) {
        this.id = UUID.randomUUID();
        this.content = content;
    }
}
