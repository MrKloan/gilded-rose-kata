package com.gildedrose.items;

public class ImprovableItem extends Item {

    private ImprovableItem(final String name, final int sellIn, final int quality) {
        super(name, sellIn, quality);
    }

    public static ImprovableItem of(final String name, final int sellIn, final int quality) {
        return new ImprovableItem(name, sellIn, quality);
    }

    @Override
    protected int updateQuality(final int updatedSellIn, int quality) {
        if (quality < 50) {
            quality = quality + 1;

            if (name.equals("Backstage passes to a TAFKAL80ETC concert")) {
                if (sellIn < 11) {
                    if (quality < 50) {
                        quality = quality + 1;
                    }
                }

                if (sellIn < 6) {
                    if (quality < 50) {
                        quality = quality + 1;
                    }
                }
            }
        }

        if (updatedSellIn < 0) {
            if (name.equals("Aged Brie")) {
                if (quality < 50) {
                    quality = quality + 1;
                }
            } else if (name.equals("Backstage passes to a TAFKAL80ETC concert")) {
                quality = 0;
            }
        }

        return quality;
    }
}
