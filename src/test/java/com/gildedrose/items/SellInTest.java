package com.gildedrose.items;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;

@DisplayName("Sell in should")
class SellInTest {

    @Test
    @DisplayName("be formatted as a string")
    void should_format_the_sell_in_as_a_string() {
        final SellIn sellIn = SellIn.of(7);

        final String result = sellIn.toString();

        assertThat(result).isEqualTo("Sell in: 7");
    }
}
