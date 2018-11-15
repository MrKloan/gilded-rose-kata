package com.gildedrose.items;

public class TicketItem extends ImprovableItem {

    private TicketItem(final String name, final SellIn sellIn, final int quality) {
        super(name, sellIn, quality);
    }

    public static TicketItem of(final String name, final int sellIn, final int quality) {
        return new TicketItem(name, SellIn.of(sellIn), quality);
    }

    @Override
    protected int updateQuality(final SellIn updatedSellIn) {
        if (updatedSellIn.isExpired())
            return 0;

        int updatedQuality = computeQuality(quality);
        if (sellIn.lessThan(11))
            updatedQuality = computeQuality(updatedQuality);

        if (sellIn.lessThan(6))
            updatedQuality = computeQuality(updatedQuality);

        return updatedQuality;
    }
}
