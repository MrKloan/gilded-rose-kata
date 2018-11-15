package com.gildedrose;

import java.util.List;

import static java.util.Arrays.asList;

class Inventory {

    private final List<Item> items;

    private Inventory(final List<Item> items) {
        this.items = items;
    }

    static Inventory of(final Item... items) {
        return new Inventory(asList(items));
    }

    void update() {
        for (final Item item : items) {
            item.update();
        }
    }

    void print(final InventoryPrinter inventoryPrinter) {
        items.stream()
                .map(Item::toString)
                .forEach(inventoryPrinter::print);
    }

    List<Item> getItems() {
        return items;
    }
}
