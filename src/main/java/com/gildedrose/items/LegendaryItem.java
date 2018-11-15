package com.gildedrose.items;

public class LegendaryItem extends Item {

    private static final int LEGENDARY_SELL_IN = 0;
    private static final int LEGENDARY_QUALITY = 80;

    private LegendaryItem(final String name) {
        super(name, LEGENDARY_SELL_IN, LEGENDARY_QUALITY);
    }

    public static LegendaryItem of(final String name) {
        return new LegendaryItem(name);
    }

    @Override
    protected int updateSellIn(final int sellIn) {
        return sellIn;
    }

    @Override
    protected int updateQuality(final int updatedSellIn) {
        return quality;
    }
}
