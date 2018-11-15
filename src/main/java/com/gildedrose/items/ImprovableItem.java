package com.gildedrose.items;

public class ImprovableItem extends Item {

    ImprovableItem(final String name, final SellIn sellIn, final Quality quality) {
        super(name, sellIn, quality);
    }

    public static ImprovableItem of(final String name, final int sellIn, final int quality) {
        return new ImprovableItem(name, SellIn.of(sellIn), Quality.of(quality));
    }

    @Override
    protected Quality updateQuality(final Quality quality) {
        return quality.increase();
    }
}
