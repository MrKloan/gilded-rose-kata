package com.gildedrose;

class InventoryItem {

    private final Item item;

    private InventoryItem(final Item item) {
        this.item = item;
    }

    static InventoryItem of(final Item item) {
        return new InventoryItem(item);
    }

    @Override
    public String toString() {
        return item.toString();
    }
}
