package com.gildedrose.items;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;

@DisplayName("Item should")
class ItemTest {

    @Test
    @DisplayName("be formatted as a string")
    void should_format_the_item_as_a_string() {
        final Item item = Item.of("Dummy", SellIn.of(3), Quality.of(7));

        final String result = item.toString();

        assertThat(result).isEqualTo("[Dummy] Sell in: 3, Quality: 7");
    }
}