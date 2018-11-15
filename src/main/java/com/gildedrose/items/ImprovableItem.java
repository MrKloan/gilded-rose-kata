package com.gildedrose.items;

public class ImprovableItem extends Item {

    ImprovableItem(final String name, final int sellIn, final int quality) {
        super(name, sellIn, quality);
    }

    public static ImprovableItem of(final String name, final int sellIn, final int quality) {
        return new ImprovableItem(name, sellIn, quality);
    }

    @Override
    protected int computeQuality(final int quality) {
        return (quality < 50)
                ? quality + 1
                : quality;
    }
}
