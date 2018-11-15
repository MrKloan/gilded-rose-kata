package com.gildedrose.items;

public class TicketItem extends ImprovableItem {

    private TicketItem(final String name, final int sellIn, final int quality) {
        super(name, sellIn, quality);
    }

    public static TicketItem of(final String name, final int sellIn, final int quality) {
        return new TicketItem(name, sellIn, quality);
    }

    @Override
    protected int updateQuality(final int updatedSellIn, int quality) {
        if (updatedSellIn < 0)
            return 0;

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

        return super.updateQuality(updatedSellIn, quality);
    }
}
