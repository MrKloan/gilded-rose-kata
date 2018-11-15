package com.gildedrose.inventory;

import com.gildedrose.items.Item;

import java.util.List;

import static java.util.Arrays.asList;

public class Inventory {

    private final List<Item> items;

    private Inventory(final List<Item> items) {
        this.items = items;
    }

    public static Inventory of(final Item... items) {
        return new Inventory(asList(items));
    }

    public void update() {
        for (final Item item : items) {
            item.update();
        }
    }

    public void print(final InventoryPrinter inventoryPrinter) {
        items.stream()
                .map(Item::toString)
                .forEach(inventoryPrinter::print);
    }
}
