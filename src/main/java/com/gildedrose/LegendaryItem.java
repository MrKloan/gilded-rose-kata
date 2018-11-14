package com.gildedrose;

class LegendaryItem extends InventoryItem {

    private static final int LEGENDARY_SELL_IN = 0;
    private static final int LEGENDARY_QUALITY = 80;

    private LegendaryItem(final Item item) {
        super(item);
    }

    static InventoryItem of(final String name) {
        final Item item = new Item(name, LEGENDARY_SELL_IN, LEGENDARY_QUALITY);
        return new LegendaryItem(item);
    }

    @Override
    protected void updateQuality() {
    }

    @Override
    protected void updateSellIn() {
    }
}
