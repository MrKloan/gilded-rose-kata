package com.gildedrose;

import com.gildedrose.inventory.Inventory;
import com.gildedrose.inventory.InventoryPrinter;

class GildedRose {

    private Inventory inventory;

    GildedRose(final Inventory inventory) {
        this.inventory = inventory;
    }

    void updateInventory() {
        inventory.update();
    }

    void printInventory(final InventoryPrinter inventoryPrinter) {
        inventory.print(inventoryPrinter);
    }
}