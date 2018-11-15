package com.gildedrose.items;

public class Item {

    private final String name;
    final SellIn sellIn;
    final Quality quality;

    Item(final String name, final SellIn sellIn, final Quality quality) {
        this.name = name;
        this.sellIn = sellIn;
        this.quality = quality;
    }

    public static Item of(final String name, final SellIn sellIn, final Quality quality) {
        return new Item(name, sellIn, quality);
    }

    public final Item update() {
        final SellIn updatedSellIn = computeSellIn();
        final Quality updatedQuality = computeQuality(updatedSellIn);

        return of(name, updatedSellIn, updatedQuality);
    }

    protected SellIn computeSellIn() {
        return sellIn.update();
    }

    protected Quality computeQuality(final SellIn updatedSellIn) {
        Quality updatedQuality = updateQuality(quality);

        if (updatedSellIn.isExpired())
            updatedQuality = updateQuality(updatedQuality);

        return updatedQuality;
    }

    protected Quality updateQuality(final Quality quality) {
        return quality.decrease();
    }

    @Override
    public final String toString() {
        return "[" + this.name + "] " + this.sellIn + ", " + this.quality;
    }
}
