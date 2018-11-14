package com.gildedrose;

import java.util.List;

import static java.util.Arrays.asList;

class GildedRose {

    private final List<InventoryItem> items;

    private GildedRose(final List<InventoryItem> items) {
        this.items = items;
    }

    static GildedRose of(final InventoryItem... inventoryItems) {
        return new GildedRose(asList(inventoryItems));
    }

    void updateQuality() {
        items.forEach(InventoryItem::update);
    }

    int getItemQuality(final int itemIndex) {
        return items.get(itemIndex).getQuality();
    }

    int getItemSellIn(final int itemIndex) {
        return items.get(itemIndex).getSellIn();
    }
}