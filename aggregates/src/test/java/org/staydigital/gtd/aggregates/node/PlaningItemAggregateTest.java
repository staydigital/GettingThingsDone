package org.staydigital.gtd.aggregates.node;


import org.junit.Test;

import static org.assertj.core.api.Assertions.assertThat;

public class PlaningItemAggregateTest {

    @Test
    public void PlaningItemAggregate_CanBeBuild() {
        PlaningItemAggregate planingItemAggregate = PlaningItemAggregate.builder().content("My content").title("My title").build();
        assertThat(planingItemAggregate.id).isNotNull();
        assertThat(planingItemAggregate.creationDate).isNotNull();
        assertThat(planingItemAggregate.planingItem).isNotNull();
        assertThat(planingItemAggregate.planingContent).isNotNull();
    }
}