package com.gildedrose;

import com.gildedrose.inventory.Inventory;
import com.gildedrose.inventory.InventoryPrinter;
import com.gildedrose.items.*;
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
        final GildedRose gildedRose = new GildedRose(Inventory.of(
                Item.of("Dummy", SellIn.of(1), Quality.of(1))
        ));

        gildedRose.updateInventory();
        gildedRose.printInventory(inventoryPrinter);

        verify(inventoryPrinter).print("[Dummy] Sell in: 0, Quality: 0");
    }

    @Test
    @DisplayName("decrease the quality of the stored item twice when its sell in is negative")
    void should_decrease_quality_of_the_stored_item_twice_when_the_inventory_is_updated_and_its_sell_in_is_negative() {
        final GildedRose gildedRose = new GildedRose(Inventory.of(
                Item.of("Dummy", SellIn.of(0), Quality.of(3))
        ));

        gildedRose.updateInventory();
        gildedRose.printInventory(inventoryPrinter);

        verify(inventoryPrinter).print("[Dummy] Sell in: -1, Quality: 1");
    }

    @Test
    @DisplayName("not decrease the quality of the stored item below 0")
    void should_not_decrease_the_quality_of_the_stored_item_below_zero_when_the_inventory_is_updated() {
        final GildedRose gildedRose = new GildedRose(Inventory.of(
                Item.of("Dummy", SellIn.of(3), Quality.of(0))
        ));

        gildedRose.updateInventory();
        gildedRose.printInventory(inventoryPrinter);

        verify(inventoryPrinter).print("[Dummy] Sell in: 2, Quality: 0");
    }

    @Test
    @DisplayName("not decrease the sell in and quality of a legendary item")
    void should_not_decrease_the_sell_in_and_quality_of_a_legendary_item_when_the_inventory_is_updated() {
        final GildedRose gildedRose = new GildedRose(Inventory.of(
                LegendaryItem.of("Sulfuras, Hand of Ragnaros")
        ));

        gildedRose.updateInventory();
        gildedRose.printInventory(inventoryPrinter);

        verify(inventoryPrinter).print("[Sulfuras, Hand of Ragnaros] Sell in: 0, Quality: 80");
    }

    @Test
    @DisplayName("increase the quality of an improvable item")
    void should_increase_the_quality_of_an_improvable_item_when_the_inventory_is_updated() {
        final GildedRose gildedRose = new GildedRose(Inventory.of(
                ImprovableItem.of("Aged Brie", SellIn.of(3), Quality.of(6))
        ));

        gildedRose.updateInventory();
        gildedRose.printInventory(inventoryPrinter);

        verify(inventoryPrinter).print("[Aged Brie] Sell in: 2, Quality: 7");
    }

    @Test
    @DisplayName("increase the quality of an improvable item twice when its sell in is negative")
    void should_increase_the_quality_of_an_improvable_item_twice_when_the_inventory_is_updated_and_its_sell_in_is_negative() {
        final GildedRose gildedRose = new GildedRose(Inventory.of(
                ImprovableItem.of("Aged Brie", SellIn.of(0), Quality.of(5))
        ));

        gildedRose.updateInventory();
        gildedRose.printInventory(inventoryPrinter);

        verify(inventoryPrinter).print("[Aged Brie] Sell in: -1, Quality: 7");
    }

    @Test
    @DisplayName("not increase the quality of an improvable item above 50")
    void should_not_increase_the_quality_of_an_improvable_item_above_fifty_when_the_inventory_is_updated() {
        final GildedRose gildedRose = new GildedRose(Inventory.of(
                ImprovableItem.of("Aged Brie", SellIn.of(7), Quality.of(50))
        ));

        gildedRose.updateInventory();
        gildedRose.printInventory(inventoryPrinter);

        verify(inventoryPrinter).print("[Aged Brie] Sell in: 6, Quality: 50");
    }

    @Test
    @DisplayName("increase the quality of a ticket item when its sell in is greater than 10")
    void should_increase_the_quality_of_a_ticket_item_when_the_inventory_is_updated_and_its_sell_in_is_greater_than_ten() {
        final GildedRose gildedRose = new GildedRose(Inventory.of(
                TicketItem.of("Backstage passes to a TAFKAL80ETC concert", SellIn.of(15), Quality.of(20))
        ));

        gildedRose.updateInventory();
        gildedRose.printInventory(inventoryPrinter);

        verify(inventoryPrinter).print("[Backstage passes to a TAFKAL80ETC concert] Sell in: 14, Quality: 21");
    }

    @Test
    @DisplayName("increase the quality of a ticket item twice when its sell in is between 10 and 5")
    void should_increase_the_quality_of_a_ticket_item_twice_when_the_inventory_is_updated_and_its_sell_in_is_between_ten_and_five() {
        final GildedRose gildedRose = new GildedRose(Inventory.of(
                TicketItem.of("Backstage passes to a TAFKAL80ETC concert", SellIn.of(10), Quality.of(20))
        ));

        gildedRose.updateInventory();
        gildedRose.printInventory(inventoryPrinter);

        verify(inventoryPrinter).print("[Backstage passes to a TAFKAL80ETC concert] Sell in: 9, Quality: 22");
    }

    @Test
    @DisplayName("increase the quality of a ticket item thrice when its sell in is between 5 and 0")
    void should_increase_the_quality_of_a_ticket_item_thrice_when_the_inventory_is_updated_and_its_sell_in_is_between_five_and_zero() {
        final GildedRose gildedRose = new GildedRose(Inventory.of(
                TicketItem.of("Backstage passes to a TAFKAL80ETC concert", SellIn.of(5), Quality.of(20))
        ));

        gildedRose.updateInventory();
        gildedRose.printInventory(inventoryPrinter);

        verify(inventoryPrinter).print("[Backstage passes to a TAFKAL80ETC concert] Sell in: 4, Quality: 23");
    }

    @Test
    @DisplayName("drop the quality of a ticket item to 0 when its sell in is negative")
    void should_drop_the_quality_of_a_ticket_item_to_zero_when_the_inventory_is_updated_and_its_sell_in_negative() {
        final GildedRose gildedRose = new GildedRose(Inventory.of(
                TicketItem.of("Backstage passes to a TAFKAL80ETC concert", SellIn.of(0), Quality.of(20))
        ));

        gildedRose.updateInventory();
        gildedRose.printInventory(inventoryPrinter);

        verify(inventoryPrinter).print("[Backstage passes to a TAFKAL80ETC concert] Sell in: -1, Quality: 0");
    }

}
