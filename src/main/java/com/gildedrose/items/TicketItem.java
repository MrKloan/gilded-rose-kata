package com.gildedrose.items;

public class TicketItem extends ImprovableItem {

    private static final int ELEVEN_DAYS = 11;
    private static final int SIX_DAYS = 6;

    private TicketItem(final String name, final SellIn sellIn, final Quality quality) {
        super(name, sellIn, quality);
    }

    public static TicketItem of(final String name, final SellIn sellIn, final Quality quality) {
        return new TicketItem(name, sellIn, quality);
    }

    @Override
    protected Quality computeQuality(final SellIn updatedSellIn) {
        if (updatedSellIn.isExpired())
            return Quality.none();

        Quality updatedQuality = updateQuality(quality);
        if (updatedSellIn.lessThan(ELEVEN_DAYS))
            updatedQuality = updateQuality(updatedQuality);

        if (updatedSellIn.lessThan(SIX_DAYS))
            updatedQuality = updateQuality(updatedQuality);

        return updatedQuality;
    }
}
