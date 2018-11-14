package com.gildedrose;

import org.junit.Test;

import static org.assertj.core.api.Assertions.assertThat;

public class ItemTest {

    @Test
    public void should_print_the_item_name_sellin_and_quality_separated_by_a_comma_and_a_space() {
        final Item item = new Item("Dummy", 3, 7);

        final String result = item.toString();

        assertThat(result).isEqualTo("Dummy, 3, 7");
    }
}