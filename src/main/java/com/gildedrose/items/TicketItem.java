package com.gildedrose.items;

public class TicketItem extends ImprovableItem {

    private TicketItem(final String name, final int sellIn, final int quality) {
        super(name, sellIn, quality);
    }

    public static TicketItem of(final String name, final int sellIn, final int quality) {
        return new TicketItem(name, sellIn, quality);
    }

    @Override
    protected int updateQuality(final int updatedSellIn) {
        int updatedQuality = computeQuality(quality);

        if (updatedSellIn < 0)
            return 0;

        if (sellIn < 11)
            updatedQuality = computeQuality(updatedQuality);

        if (sellIn < 6)
            updatedQuality = computeQuality(updatedQuality);

        return updatedQuality;
    }
}
