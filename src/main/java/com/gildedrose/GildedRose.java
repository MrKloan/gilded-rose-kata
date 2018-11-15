package com.gildedrose;

import java.util.List;

class GildedRose {

    private List<Item> items;

    GildedRose(final Inventory inventory) {
        this.items = inventory.getItems();
    }

    void updateInventory() {
        for (final Item item : items) {
            item.update();
        }
    }

    void printInventory(final InventoryPrinter inventoryPrinter) {
        items.stream()
                .map(Item::toString)
                .forEach(inventoryPrinter::print);
    }
}