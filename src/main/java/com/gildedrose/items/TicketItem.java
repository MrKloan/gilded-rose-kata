package com.gildedrose.items;

public class TicketItem extends ImprovableItem {

    private static final Quality NO_QUALITY = Quality.of(0);
    private static final int ELEVEN_DAYS = 11;
    private static final int SIX_DAYS = 6;

    private TicketItem(final String name, final SellIn sellIn, final Quality quality) {
        super(name, sellIn, quality);
    }

    public static TicketItem of(final String name, final int sellIn, final int quality) {
        return new TicketItem(name, SellIn.of(sellIn), Quality.of(quality));
    }

    @Override
    protected Quality computeQuality(final SellIn updatedSellIn) {
        if (updatedSellIn.isExpired())
            return NO_QUALITY;

        Quality updatedQuality = updateQuality(quality);
        if (sellIn.lessThan(ELEVEN_DAYS))
            updatedQuality = updateQuality(updatedQuality);

        if (sellIn.lessThan(SIX_DAYS))
            updatedQuality = updateQuality(updatedQuality);

        return updatedQuality;
    }
}
