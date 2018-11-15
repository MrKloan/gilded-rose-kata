package com.gildedrose.items;

public class Item {

    private final String name;
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

    public final void update() {
        final int updatedSellIn = updateSellIn(sellIn);

        quality = updateQuality(updatedSellIn);
        sellIn = updatedSellIn;
    }

    protected int updateSellIn(final int sellIn) {
        return sellIn - 1;
    }

    protected int updateQuality(final int updatedSellIn) {
        int updatedQuality = computeQuality(quality);

        if (updatedSellIn < 0)
            updatedQuality = computeQuality(updatedQuality);

        return updatedQuality;
    }

    protected int computeQuality(final int quality) {
        return (quality > 0)
                ? quality - 1
                : quality;
    }

    @Override
    public final String toString() {
        return "[" + this.name + "] Sell in: " + this.sellIn + ", Quality: " + this.quality;
    }
}
