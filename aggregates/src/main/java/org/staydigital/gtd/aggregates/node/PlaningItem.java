package org.staydigital.gtd.aggregates.node;

import java.util.UUID;

class PlaningItem {

    UUID id;

    String title;

    PlaningItem(final String title) {
        this.id = UUID.randomUUID();
        this.title = title;
    }
}
