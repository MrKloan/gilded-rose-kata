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

    List<Item> getItems() {
        return items;
    }
}
