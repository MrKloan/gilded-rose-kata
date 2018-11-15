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
        final SellIn updatedSellIn = computeSellIn();

        quality = computeQuality(updatedSellIn);
        sellIn = updatedSellIn;
    }

    protected SellIn computeSellIn() {
        return sellIn.update();
    }

    protected int computeQuality(final SellIn updatedSellIn) {
        int updatedQuality = updateQuality(quality);

        if (updatedSellIn.isExpired())
            updatedQuality = updateQuality(updatedQuality);

        return updatedQuality;
    }

    protected int updateQuality(final int quality) {
        return (quality > 0)
                ? quality - 1
                : quality;
    }

    @Override
    public final String toString() {
        return "[" + this.name + "] " + this.sellIn + ", Quality: " + this.quality;
    }
}
