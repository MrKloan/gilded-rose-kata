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

    private Item[] inventory(final Item item) {
        return new Item[]{item};
    }
}
