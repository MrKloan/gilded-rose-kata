package com.gildedrose;

import java.util.List;

class GildedRose {

    private Inventory inventory;
    private List<Item> items;

    GildedRose(final Inventory inventory) {
        this.inventory = inventory;
        this.items = inventory.getItems();
    }

    void updateInventory() {
        for (final Item item : items) {
            item.update();
        }
    }

    void printInventory(final InventoryPrinter inventoryPrinter) {
        inventory.print(inventoryPrinter);
    }
}