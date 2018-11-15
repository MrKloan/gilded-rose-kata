package com.gildedrose.items;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;

@DisplayName("Sell in should")
class SellInTest {

    @Test
    @DisplayName("not be expired when its value is positive")
    void should_not_be_expired_when_the_sell_in_value_is_positive() {
        final SellIn sellIn = SellIn.of(7);

        final boolean isExpired = sellIn.isExpired();

        assertThat(isExpired).isFalse();
    }

    @Test
    @DisplayName("be expired when its value is positive")
    void should_be_expired_when_the_sell_in_value_is_negative() {
        final SellIn sellIn = SellIn.of(-1);

        final boolean isExpired = sellIn.isExpired();

        assertThat(isExpired).isTrue();
    }

    @Test
    @DisplayName("be formatted as a string")
    void should_format_the_sell_in_as_a_string() {
        final SellIn sellIn = SellIn.of(7);

        final String result = sellIn.toString();

        assertThat(result).isEqualTo("Sell in: 7");
    }
}
