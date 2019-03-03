package org.staydigital.gtd.aggregates.node;

import java.util.UUID;

class PlaningContent {

    UUID id;
    String content;

    PlaningContent(final String content) {
        this.id = UUID.randomUUID();
        this.content = content;
    }
}
