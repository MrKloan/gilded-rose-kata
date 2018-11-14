package com.gildedrose;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;

@DisplayName("Item should")
class ItemTest {

    @Test
    @DisplayName("print its name, sellIn and quality separated by a comma and a space")
    void should_print_the_item_name_sellin_and_quality_separated_by_a_comma_and_a_space() {
        final Item item = new Item("Dummy", 3, 7);

        final String result = item.toString();

        assertThat(result).isEqualTo("Dummy, 3, 7");
    }
}