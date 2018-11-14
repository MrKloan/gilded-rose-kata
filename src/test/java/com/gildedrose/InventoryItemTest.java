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

    @Test
    @DisplayName("return the item sellIn")
    void should_get_the_item_sellin() {
        final Item item = new Item("Dummy", 3, 7);

        final int sellIn = InventoryItem.of(item).getSellIn();

        assertThat(sellIn).isEqualTo(3);
    }

    @Test
    @DisplayName("return the item quality")
    void should_get_the_item_quality() {
        final Item item = new Item("Dummy", 3, 7);

        final int sellIn = InventoryItem.of(item).getQuality();

        assertThat(sellIn).isEqualTo(7);
    }
}
