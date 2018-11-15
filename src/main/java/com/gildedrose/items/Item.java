package com.gildedrose.items;

public class Item {

    private final String name;
    SellIn sellIn;
    int quality;

    Item(final String name, final SellIn sellIn, final int quality) {
        this.name = name;
        this.sellIn = sellIn;
        this.quality = quality;
    }

    public static Item of(final String name, final SellIn sellIn, final int quality) {
        return new Item(name, sellIn, quality);
    }

    public final void update() {
        final SellIn updatedSellIn = updateSellIn();

        quality = updateQuality(updatedSellIn);
        sellIn = updatedSellIn;
    }

    protected SellIn updateSellIn() {
        return sellIn.update();
    }

    protected int updateQuality(final SellIn updatedSellIn) {
        int updatedQuality = computeQuality(quality);

        if (updatedSellIn.isExpired())
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
        return "[" + this.name + "] " + this.sellIn + ", Quality: " + this.quality;
    }
}
