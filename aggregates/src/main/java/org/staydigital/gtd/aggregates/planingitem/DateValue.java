package org.staydigital.gtd.aggregates.planingitem;

import lombok.Data;

import java.time.Instant;

/**
 * Simple Wrapper object for date values
 *
 * @author Wittmann
 * @since 1.0.0
 */
@Data
class DateValue  {

    private Instant date;

    DateValue(final Instant timestamp) {
        date = timestamp;
    }
}
