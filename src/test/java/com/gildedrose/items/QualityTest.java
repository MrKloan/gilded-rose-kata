package com.gildedrose.items;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;

@DisplayName("Quality should")
class QualityTest {

    @Test
    @DisplayName("be increased when its value is under 50")
    void should_increase_the_quality_when_its_value_is_under_fifty() {
        final Quality quality = Quality.of(6);

        final Quality result = quality.increase();

        assertThat(result).isEqualTo(Quality.of(7));
    }

    @Test
    @DisplayName("not be increased when its value is equal to 50")
    void should_increase_the_quality_when_its_value_is_equal_to_fifty() {
        final Quality quality = Quality.of(50);

        final Quality result = quality.increase();

        assertThat(result).isEqualTo(Quality.of(50));
    }

    @Test
    @DisplayName("be decreased when its value is above 0")
    void should_decrease_the_quality_when_its_value_is_above_zero() {
        final Quality quality = Quality.of(8);

        final Quality result = quality.decrease();

        assertThat(result).isEqualTo(Quality.of(7));
    }

    @Test
    @DisplayName("not be decreased when its value is equal to 0")
    void should_not_decrease_the_quality_when_its_value_is_equal_to_zero() {
        final Quality quality = Quality.of(0);

        final Quality result = quality.increase();

        assertThat(result).isEqualTo(Quality.of(0));
    }

    @Test
    @DisplayName("be equal to another quality holding the same value")
    void should_be_equal() {
        final Quality firstQuality = Quality.of(7);
        final Quality secondQuality = Quality.of(7);

        assertThat(firstQuality).isEqualTo(secondQuality);
        assertThat(firstQuality.hashCode()).isEqualTo(secondQuality.hashCode());
    }

    @Test
    @DisplayName("not be equal to another quality holding a different value")
    void should_not_be_equal() {
        final Quality firstQuality = Quality.of(7);
        final Quality secondQuality = Quality.of(5);

        assertThat(firstQuality).isNotEqualTo(secondQuality);
        assertThat(firstQuality.hashCode()).isNotEqualTo(secondQuality.hashCode());
    }

    @Test
    @DisplayName("be formatted as a string")
    void should_format_the_quality_as_a_string() {
        final Quality quality = Quality.of(7);

        final String result = quality.toString();

        assertThat(result).isEqualTo("Quality: 7");
    }
}
