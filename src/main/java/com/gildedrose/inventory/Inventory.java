package com.gildedrose.inventory;

import com.gildedrose.items.Item;

import java.util.List;

import static java.util.Arrays.asList;
import static java.util.Collections.unmodifiableList;
import static java.util.stream.Collectors.toList;

public class Inventory {

    private final List<Item> items;

    private Inventory(final List<Item> items) {
        this.items = unmodifiableList(items);
    }

    public static Inventory of(final Item... items) {
        return new Inventory(asList(items));
    }

    public Inventory update() {
        List<Item> updatedItems = items.stream()
                .map(Item::update)
                .collect(toList());

        return new Inventory(updatedItems);
    }

    public void print(final InventoryPrinter inventoryPrinter) {
        items.stream()
                .map(Item::toString)
                .forEach(inventoryPrinter::print);
    }
}
