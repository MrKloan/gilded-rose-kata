package com.gildedrose.items;

public class Item {

    private final String name;
    private int sellIn;
    private int quality;

    private Item(String name, int sellIn, int quality) {
        this.name = name;
        this.sellIn = sellIn;
        this.quality = quality;
    }

    public static Item of(final String name, final int sellIn, final int quality) {
        return new Item(name, sellIn, quality);
    }

    public void update() {
        if (name.equals("Sulfuras, Hand of Ragnaros"))
            return;

        final int updatedSellIn = this.sellIn - 1;

        quality = computeQuality(quality);
        quality = computeQualityAfterSellInUpdate(updatedSellIn, quality);

        this.sellIn = updatedSellIn;
    }

    private int computeQuality(int quality) {
        if (name.equals("Aged Brie")
                || name.equals("Backstage passes to a TAFKAL80ETC concert")) {
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
        } else if (quality > 0) {
            quality = quality - 1;
        }

        return quality;
    }

    private int computeQualityAfterSellInUpdate(int sellIn, int quality) {
        if (sellIn < 0) {
            if (name.equals("Aged Brie")) {
                if (quality < 50) {
                    quality = quality + 1;
                }
            } else {
                if (name.equals("Backstage passes to a TAFKAL80ETC concert")) {
                    quality = 0;
                } else {
                    if (quality > 0) {
                        quality = quality - 1;
                    }
                }
            }
        }

        return quality;
    }

    @Override
    public String toString() {
        return "[" + this.name + "] Sell in: " + this.sellIn + ", Quality: " + this.quality;
    }
}
