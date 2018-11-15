package com.gildedrose;

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