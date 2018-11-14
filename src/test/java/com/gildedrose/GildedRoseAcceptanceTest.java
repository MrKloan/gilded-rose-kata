package com.gildedrose;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;

@DisplayName("When I update the inventory it should")
class GildedRoseAcceptanceTest {

    @Test
    @DisplayName("decease the item sellIn")
    void should_decrease_the_item_sellin_when_the_inventory_is_updated() {
        final GildedRose gildedRose = GildedRose.of(InventoryItem.of(new Item("Dummy", 1, 1)));

        gildedRose.updateQuality();

        assertThat(gildedRose.getItemSellIn(0)).isEqualTo(0);
    }

    @Test
    @DisplayName("decrease the item quality")
    void should_decrease_the_item_quality_when_the_inventory_is_updated() {
        final GildedRose gildedRose = GildedRose.of(InventoryItem.of(new Item("Dummy", 1, 1)));

        gildedRose.updateQuality();

        assertThat(gildedRose.getItemQuality(0)).isEqualTo(0);
    }

    @Test
    @DisplayName("decrease the item quality twice when its sellIn is negative")
    void should_decrease_the_item_quality_twice_when_the_inventory_is_updated_and_the_item_sellin_is_negative() {
        final GildedRose gildedRose = GildedRose.of(InventoryItem.of(new Item("Dummy", 0, 3)));

        gildedRose.updateQuality();

        assertThat(gildedRose.getItemQuality(0)).isEqualTo(1);
    }

    @Test
    @DisplayName("not decrease the item quality below 0")
    void should_not_decrease_the_item_quality_below_zero_when_the_inventory_is_updated() {
        final GildedRose gildedRose = GildedRose.of(InventoryItem.of(new Item("Dummy", 3, 0)));

        gildedRose.updateQuality();

        assertThat(gildedRose.getItemQuality(0)).isEqualTo(0);
    }

    @Test
    @DisplayName("increase the quality of an improvable item when its sellIn is positive")
    void should_increase_the_quality_of_an_improvable_item_when_the_inventory_is_updated_and_its_sellin_is_positive() {
        final GildedRose gildedRose = GildedRose.of(ImprovableItem.of(new Item("Aged Brie", 3, 6)));

        gildedRose.updateQuality();

        assertThat(gildedRose.getItemQuality(0)).isEqualTo(7);
    }

    @Test
    @DisplayName("increase the quality of an improvable item twice when its sellIn is negative")
    void should_increase_the_quality_of_an_improvable_item_twice_when_the_inventory_is_updated_and_its_sellin_is_negative() {
        final GildedRose gildedRose = GildedRose.of(ImprovableItem.of(new Item("Aged Brie", 0, 5)));

        gildedRose.updateQuality();

        assertThat(gildedRose.getItemQuality(0)).isEqualTo(7);
    }

    @Test
    @DisplayName("not increase the quality of an improvable item above 50")
    void should_not_increase_the_quality_of_an_improvable_item_above_fifty_when_the_inventory_is_updated() {
        final GildedRose gildedRose = GildedRose.of(ImprovableItem.of(new Item("Aged Brie", 7, 50)));

        gildedRose.updateQuality();

        assertThat(gildedRose.getItemQuality(0)).isEqualTo(50);
    }

    @Test
    @DisplayName("not decrease the quality of a legendary item")
    void should_not_decrease_the_quality_of_a_legendary_item_when_the_inventory_is_updated() {
        final GildedRose gildedRose = GildedRose.of(LegendaryItem.of("Sulfuras, Hand of Ragnaros"));

        gildedRose.updateQuality();

        assertThat(gildedRose.getItemQuality(0)).isEqualTo(80);
    }

    @Test
    @DisplayName("not decrease the sellIn of a legendary item")
    void should_not_decrease_the_sellin_of_a_legendary_item_when_the_inventory_is_updated() {
        final GildedRose gildedRose = GildedRose.of(LegendaryItem.of("Sulfuras, Hand of Ragnaros"));

        gildedRose.updateQuality();

        assertThat(gildedRose.getItemSellIn(0)).isEqualTo(0);
    }

    @Test
    @DisplayName("increase the quality of a ticket item when its sellIn is above 10")
    void should_increase_the_quality_of_a_ticket_item_when_the_inventory_is_updated_and_its_sellin_is_above_10() {
        final GildedRose gildedRose = GildedRose.of(TicketItem.of(new Item("Backstage passes to a TAFKAL80ETC concert", 15, 20)));

        gildedRose.updateQuality();

        assertThat(gildedRose.getItemQuality(0)).isEqualTo(21);
    }

    @Test
    @DisplayName("increase the quality of a ticket item twice when its sellIn is between 10 and 5")
    void should_increase_the_quality_of_a_ticket_item_twice_when_the_inventory_is_updated_and_its_sellin_is_between_10_and_5() {
        final GildedRose gildedRose = GildedRose.of(TicketItem.of(new Item("Backstage passes to a TAFKAL80ETC concert", 10, 20)));

        gildedRose.updateQuality();

        assertThat(gildedRose.getItemQuality(0)).isEqualTo(22);
    }

    @Test
    @DisplayName("increase the quality of a ticket item thrice when its sellIn is between 5 and 0")
    void should_increase_the_quality_of_a_ticket_item_thrice_when_the_inventory_is_updated_and_its_sellin_is_between_5_and_0() {
        final GildedRose gildedRose = GildedRose.of(TicketItem.of(new Item("Backstage passes to a TAFKAL80ETC concert", 5, 20)));

        gildedRose.updateQuality();

        assertThat(gildedRose.getItemQuality(0)).isEqualTo(23);
    }

    @Test
    @DisplayName("drop the quality of a ticket item to 0 when its sellIn negative")
    void should_drop_the_quality_of_a_ticket_item_to_zero_when_the_inventory_is_updated_and_its_sellin_is_negative() {
        final GildedRose gildedRose = GildedRose.of(TicketItem.of(new Item("Backstage passes to a TAFKAL80ETC concert", 0, 20)));

        gildedRose.updateQuality();

        assertThat(gildedRose.getItemQuality(0)).isEqualTo(0);
    }
}
