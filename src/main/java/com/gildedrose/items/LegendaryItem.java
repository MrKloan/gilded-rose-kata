package com.gildedrose.items;

public class LegendaryItem extends Item {

    private static final SellIn LEGENDARY_SELL_IN = SellIn.of(0);
    private static final Quality LEGENDARY_QUALITY = Quality.of(80);

    private LegendaryItem(final String name) {
        super(name, LEGENDARY_SELL_IN, LEGENDARY_QUALITY);
    }

    public static LegendaryItem of(final String name) {
        return new LegendaryItem(name);
    }

    @Override
    protected SellIn computeSellIn() {
        return sellIn;
    }

    @Override
    protected Quality computeQuality(final SellIn updatedSellIn) {
        return quality;
    }
}
