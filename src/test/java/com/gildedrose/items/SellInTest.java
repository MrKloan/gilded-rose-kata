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
    @DisplayName("not be less than the provided number of days")
    void should_not_be_sold_in_less_than_the_provided_number_of_days() {
        final SellIn sellIn = SellIn.of(12);

        final boolean isLessThan = sellIn.lessThan(10);

        assertThat(isLessThan).isFalse();
    }

    @Test
    @DisplayName("be less than the provided number of days")
    void should_be_sold_in_less_than_the_provided_number_of_days() {
        final SellIn sellIn = SellIn.of(7);

        final boolean isLessThan = sellIn.lessThan(10);

        assertThat(isLessThan).isTrue();
    }

    @Test
    @DisplayName("be formatted as a string")
    void should_format_the_sell_in_as_a_string() {
        final SellIn sellIn = SellIn.of(7);

        final String result = sellIn.toString();

        assertThat(result).isEqualTo("Sell in: 7");
    }
}
