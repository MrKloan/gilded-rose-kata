package com.gildedrose;

import org.junit.Test;

import static org.assertj.core.api.Assertions.assertThat;

public class GildedRoseAcceptanceTest {

    @Test
    public void should_decrease_the_item_quality_when_the_inventory_is_updated() {
        final Item item = new Item("Dummy", 1, 1);
        final Item[] items = new Item[]{item};
        final GildedRose gildedRose = new GildedRose(items);

        gildedRose.updateQuality();

        assertThat(gildedRose.getItemQuality(0)).isEqualTo(0);
    }

    @Test
    public void should_decrease_the_item_sellin_when_the_inventory_is_updated() {
        final Item item = new Item("Dummy", 1, 1);
        final Item[] items = new Item[]{item};
        final GildedRose gildedRose = new GildedRose(items);

        gildedRose.updateQuality();

        assertThat(gildedRose.getItemSellIn(0)).isEqualTo(0);
    }

    @Test
    public void should_decrease_the_item_quality_twice_when_the_inventory_is_updated_and_the_item_sellin_is_negative() {
        final Item item = new Item("Dummy", 0, 4);
        final Item[] items = new Item[]{item};
        final GildedRose gildedRose = new GildedRose(items);

        gildedRose.updateQuality();

        assertThat(gildedRose.getItemQuality(0)).isEqualTo(2);
    }
}
