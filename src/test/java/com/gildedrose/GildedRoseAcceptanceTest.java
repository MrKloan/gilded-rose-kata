package com.gildedrose;


import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;

@DisplayName("When I update the inventory it should")
class GildedRoseAcceptanceTest {

    @Test
    @DisplayName("decease the item sellIn")
    void should_decrease_the_item_sellin_when_the_inventory_is_updated() {
        final Item item = new Item("Dummy", 1, 1);
        final Item[] items = new Item[]{item};
        final GildedRose gildedRose = new GildedRose(items);

        gildedRose.updateQuality();

        assertThat(gildedRose.getItemSellIn(0)).isEqualTo(0);
    }

    @Test
    @DisplayName("decrease the item quality")
    void should_decrease_the_item_quality_when_the_inventory_is_updated() {
        final Item item = new Item("Dummy", 1, 1);
        final Item[] items = new Item[]{item};
        final GildedRose gildedRose = new GildedRose(items);

        gildedRose.updateQuality();

        assertThat(gildedRose.getItemQuality(0)).isEqualTo(0);
    }

    @Test
    @DisplayName("decrease the item quality twice when its sellIn is negative")
    void should_decrease_the_item_quality_twice_when_the_inventory_is_updated_and_the_item_sellin_is_negative() {
        final Item item = new Item("Dummy", 0, 3);
        final Item[] items = new Item[]{item};
        final GildedRose gildedRose = new GildedRose(items);

        gildedRose.updateQuality();

        assertThat(gildedRose.getItemQuality(0)).isEqualTo(1);
    }

    @Test
    @DisplayName("not decrease the item quality below 0")
    void should_not_decrease_the_item_quality_below_zero_when_the_inventory_is_updated() {
        final Item item = new Item("Dummy", 3, 0);
        final Item[] items = new Item[]{item};
        final GildedRose gildedRose = new GildedRose(items);

        gildedRose.updateQuality();

        assertThat(gildedRose.getItemQuality(0)).isEqualTo(0);
    }

    @Test
    @DisplayName("increase the quality of Aged Brie when its sellIn is positive")
    void should_increase_the_quality_of_aged_brie_when_the_inventory_is_updated_and_its_sellin_is_positive() {
        final Item item = new Item("Aged Brie", 3, 6);
        final Item[] items = new Item[]{item};
        final GildedRose gildedRose = new GildedRose(items);

        gildedRose.updateQuality();

        assertThat(gildedRose.getItemQuality(0)).isEqualTo(7);
    }

    @Test
    @DisplayName("increase the quality of Aged Brie twice when its sellIn is negative")
    void should_increase_the_quality_of_aged_brie_twice_when_the_inventory_is_updated_and_its_sellin_is_negative() {
        final Item item = new Item("Aged Brie", 0, 5);
        final Item[] items = new Item[]{item};
        final GildedRose gildedRose = new GildedRose(items);

        gildedRose.updateQuality();

        assertThat(gildedRose.getItemQuality(0)).isEqualTo(7);
    }

    @Test
    @DisplayName("not increase the quality of an item above 50")
    void should_not_increase_the_quality_of_an_item_above_fifty_when_the_inventory_is_updated() {
        final Item item = new Item("Aged Brie", 7, 50);
        final Item[] items = new Item[]{item};
        final GildedRose gildedRose = new GildedRose(items);

        gildedRose.updateQuality();

        assertThat(gildedRose.getItemQuality(0)).isEqualTo(50);
    }

    @Test
    @DisplayName("not decrease the quality of a legendary item")
    void should_not_decrease_the_quality_of_a_legendary_item_when_the_inventory_is_updated() {
        final Item item = new Item("Sulfuras, Hand of Ragnaros", 0, 80);
        final Item[] items = new Item[]{item};
        final GildedRose gildedRose = new GildedRose(items);

        gildedRose.updateQuality();

        assertThat(gildedRose.getItemQuality(0)).isEqualTo(80);
    }
}
