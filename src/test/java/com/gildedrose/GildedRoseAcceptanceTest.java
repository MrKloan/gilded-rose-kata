package com.gildedrose;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import static org.mockito.Mockito.verify;

@ExtendWith(MockitoExtension.class)
@DisplayName("When I update the Gilded Rose's inventory it should")
class GildedRoseAcceptanceTest {

    @Mock
    private InventoryPrinter inventoryPrinter;

    @Test
    @DisplayName("decrease the sell in and quality of the stored item")
    void should_decrease_the_sell_in_and_quality_of_the_stored_item_when_the_inventory_is_updated() {
        final GildedRose gildedRose = new GildedRose(inventory(
                Item.of("Dummy", 1, 1)
        ));

        gildedRose.updateQuality();
        gildedRose.printInventory(inventoryPrinter);

        verify(inventoryPrinter).print("[Dummy] Sell in: 0, Quality: 0");
    }

    @Test
    @DisplayName("decrease the quality of the stored item twice when its sell in is negative")
    void should_decrease_quality_of_the_stored_item_twice_when_the_inventory_is_updated_and_its_sell_in_is_negative() {
        final GildedRose gildedRose = new GildedRose(inventory(
                Item.of("Dummy", 0, 3)
        ));

        gildedRose.updateQuality();
        gildedRose.printInventory(inventoryPrinter);

        verify(inventoryPrinter).print("[Dummy] Sell in: -1, Quality: 1");
    }

    @Test
    @DisplayName("not decrease the quality of the stored item below 0")
    void should_not_decrease_the_quality_of_the_stored_item_below_zero_when_the_inventory_is_updated() {
        final GildedRose gildedRose = new GildedRose(inventory(
                Item.of("Dummy", 3, 0)
        ));

        gildedRose.updateQuality();
        gildedRose.printInventory(inventoryPrinter);

        verify(inventoryPrinter).print("[Dummy] Sell in: 2, Quality: 0");
    }

    @Test
    @DisplayName("not decrease the sell in and quality of a legendary item")
    void should_not_decrease_the_sell_in_and_quality_of_a_legendary_item_when_the_inventory_is_updated() {
        final GildedRose gildedRose = new GildedRose(inventory(
                Item.of("Sulfuras, Hand of Ragnaros", 0, 80)
        ));

        gildedRose.updateQuality();
        gildedRose.printInventory(inventoryPrinter);

        verify(inventoryPrinter).print("[Sulfuras, Hand of Ragnaros] Sell in: 0, Quality: 80");
    }

    @Test
    @DisplayName("increase the quality of an improvable item")
    void should_increase_the_quality_of_an_improvable_item_when_the_inventory_is_updated() {
        final GildedRose gildedRose = new GildedRose(inventory(
                Item.of("Aged Brie", 3, 6)
        ));

        gildedRose.updateQuality();
        gildedRose.printInventory(inventoryPrinter);

        verify(inventoryPrinter).print("[Aged Brie] Sell in: 2, Quality: 7");
    }

    @Test
    @DisplayName("increase the quality of an improvable item twice when its sell in is negative")
    void should_increase_the_quality_of_an_improvable_item_twice_when_the_inventory_is_updated_and_its_sell_in_is_negative() {
        final GildedRose gildedRose = new GildedRose(inventory(
                Item.of("Aged Brie", 0, 5)
        ));

        gildedRose.updateQuality();
        gildedRose.printInventory(inventoryPrinter);

        verify(inventoryPrinter).print("[Aged Brie] Sell in: -1, Quality: 7");
    }

    private Item[] inventory(final Item item) {
        return new Item[]{item};
    }
}
