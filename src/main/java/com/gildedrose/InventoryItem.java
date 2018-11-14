package com.gildedrose;

class InventoryItem {

    static final int SELLIN_THRESHOLD = 0;
    static final int MINIMUM_QUALITY = 0;

    final Item item;

    InventoryItem(final Item item) {
        this.item = item;
    }

    static InventoryItem of(final Item item) {
        return new InventoryItem(item);
    }

    void update() {
        updateQuality();
        updateSellIn();
    }

    protected void updateQuality() {
        if (item.quality > MINIMUM_QUALITY)
            item.quality = item.quality - 1;
    }

    protected void updateSellIn() {
        item.sellIn = item.sellIn - 1;

        if (item.sellIn < SELLIN_THRESHOLD)
            updateQuality();
    }

    int getSellIn() {
        return item.sellIn;
    }

    int getQuality() {
        return item.quality;
    }

    @Override
    public String toString() {
        return item.toString();
    }
}
