package com.gildedrose.items;

public class ImprovableItem extends Item {

    ImprovableItem(final String name, final int sellIn, final int quality) {
        super(name, sellIn, quality);
    }

    public static ImprovableItem of(final String name, final int sellIn, final int quality) {
        return new ImprovableItem(name, sellIn, quality);
    }

    @Override
    protected int updateQuality(final int updatedSellIn, int quality) {
        if (quality < 50) {
            quality = quality + 1;
        }

        if (updatedSellIn < 0 && quality < 50) {
            quality = quality + 1;
        }

        return quality;
    }
}
