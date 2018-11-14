package com.gildedrose;

class TicketItem extends ImprovableItem {

    private TicketItem(final Item item) {
        super(item);
    }

    static InventoryItem of(final Item item) {
        return new TicketItem(item);
    }

    @Override
    protected void updateQuality() {
        super.updateQuality();

        if (item.sellIn < 11)
            super.updateQuality();
        if (item.sellIn < 6)
            super.updateQuality();
    }

    @Override
    protected void updateSellIn() {
        item.sellIn = item.sellIn - 1;

        if (item.sellIn < SELLIN_THRESHOLD)
            item.quality = MINIMUM_QUALITY;
    }
}
