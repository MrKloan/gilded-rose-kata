package com.gildedrose;

public class Item {

    final String name;
    int sellIn;
    int quality;

    private Item(String name, int sellIn, int quality) {
        this.name = name;
        this.sellIn = sellIn;
        this.quality = quality;
    }

    static Item of(final String name, final int sellIn, final int quality) {
        return new Item(name, sellIn, quality);
    }

    @Override
    public String toString() {
        return "[" + this.name + "] Sell in: " + this.sellIn + ", Quality: " + this.quality;
    }
}
