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
    @DisplayName("decrement its number of days when it is updated")
    void should_decrement_the_number_of_days_when_the_sell_in_is_updated() {
        final SellIn sellIn = SellIn.of(7);

        final SellIn updatedSellIn = sellIn.update();

        assertThat(updatedSellIn).isEqualTo(SellIn.of(6));
    }

    @Test
    @DisplayName("be equal to another SellIn holding the same number of days")
    void should_be_equal() {
        final SellIn firstSellIn = SellIn.of(7);
        final SellIn secondSellIn = SellIn.of(7);

        assertThat(firstSellIn).isEqualTo(secondSellIn);
        assertThat(firstSellIn.hashCode()).isEqualTo(secondSellIn.hashCode());
    }

    @Test
    @DisplayName("not be equal to another SellIn holding a different number of days")
    void should_not_be_equal() {
        final SellIn firstSellIn = SellIn.of(7);
        final SellIn secondSellIn = SellIn.of(5);

        assertThat(firstSellIn).isNotEqualTo(secondSellIn);
        assertThat(firstSellIn.hashCode()).isNotEqualTo(secondSellIn.hashCode());
    }

    @Test
    @DisplayName("be formatted as a string")
    void should_format_the_sell_in_as_a_string() {
        final SellIn sellIn = SellIn.of(7);

        final String result = sellIn.toString();

        assertThat(result).isEqualTo("Sell in: 7");
    }
}
