package com.gildedrose;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;

@DisplayName("Inventory Item should")
class InventoryItemTest {

    @Test
    @DisplayName("print the decorated item as is")
    void should_print_the_decorated_item() {
        final Item item = new Item("Dummy", 3, 7);

        final String result = InventoryItem.of(item).toString();

        assertThat(result).isEqualTo("Dummy, 3, 7");
    }
}
