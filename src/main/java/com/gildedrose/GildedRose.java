package com.gildedrose;

import static java.util.Arrays.stream;

class GildedRose {

    private Item[] items;

    GildedRose(Item[] items) {
        this.items = items;
    }

    void updateInventory() {
        for (final Item item : items) {
            item.update();
        }
    }

    void printInventory(final InventoryPrinter inventoryPrinter) {
        stream(items)
                .map(Item::toString)
                .forEach(inventoryPrinter::print);
    }
}