package com.gildedrose.items;

public class Item {

    final String name;
    int sellIn;
    int quality;

    Item(final String name, final int sellIn, final int quality) {
        this.name = name;
        this.sellIn = sellIn;
        this.quality = quality;
    }

    public static Item of(final String name, final int sellIn, final int quality) {
        return new Item(name, sellIn, quality);
    }

    public void update() {
        final int updatedSellIn = updateSellIn(sellIn);

        quality = updateQuality(updatedSellIn, quality);
        sellIn = updatedSellIn;
    }

    protected int updateSellIn(final int sellIn) {
        return sellIn - 1;
    }

    protected int updateQuality(final int updatedSellIn, int quality) {
        if (quality > 0) {
            quality = quality - 1;
        }

        if (updatedSellIn < 0 && quality > 0)
            quality = quality - 1;

        return quality;
    }

    @Override
    public String toString() {
        return "[" + this.name + "] Sell in: " + this.sellIn + ", Quality: " + this.quality;
    }
}
