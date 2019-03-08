package org.staydigital.gtd.aggregates.planingitem;

/**
 * States of a Planing Item.
 *
 * INITIALIZED - created and or modified already
 * REVIEWED - Planing Item was reviewed and was assigned a Task Item(no modification on Planing Item
 *            allowed anymore)
 * CLOSED - Corresponding Task Item has become complete
 *
 * @author Wittmann
 * @since 1.0.0
 */
enum PlaningItemState {

    INITIALIZED,
    REVIEWED,
    CLOSED

}
