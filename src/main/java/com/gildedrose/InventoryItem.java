package com.gildedrose;

class InventoryItem {

    private final Item item;

    private InventoryItem(final Item item) {
        this.item = item;
    }

    static InventoryItem of(final Item item) {
        return new InventoryItem(item);
    }

    void update() {
        updateQuality();
        updateSellIn();
    }

    private void updateQuality() {
        if (item.name.equals("Sulfuras, Hand of Ragnaros"))
            return;

        if (item.name.equals("Aged Brie") || item.name.equals("Backstage passes to a TAFKAL80ETC concert"))
            updateImprovableItemQuality();
        else
            decreaseQuality();
    }

    private void updateImprovableItemQuality() {
        if (item.quality >= 50)
            return;

        item.quality = item.quality + 1;

        if (item.name.equals("Backstage passes to a TAFKAL80ETC concert"))
            updateBackstagePassQuality();
    }

    private void updateBackstagePassQuality() {
        if (item.sellIn < 11)
            increaseQuality();
        if (item.sellIn < 6)
            increaseQuality();
    }

    private void updateSellIn() {
        if (item.name.equals("Sulfuras, Hand of Ragnaros"))
            return;

        item.sellIn = item.sellIn - 1;

        if (item.sellIn < 0) {
            if (item.name.equals("Aged Brie")) {
                increaseQuality();
            } else {
                if (item.name.equals("Backstage passes to a TAFKAL80ETC concert"))
                    item.quality = 0;
                else
                    decreaseQuality();
            }
        }
    }

    private void increaseQuality() {
        if (item.quality < 50)
            item.quality = item.quality + 1;
    }

    private void decreaseQuality() {
        if (item.quality > 0)
            item.quality = item.quality - 1;
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
