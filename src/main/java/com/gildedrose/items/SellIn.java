package com.gildedrose.items;

class SellIn {

    private final int days;

    private SellIn(final int days) {
        this.days = days;
    }

    public static SellIn of(final int days) {
        return new SellIn(days);
    }

    boolean hasPassed() {
        return false;
    }

    @Override
    public String toString() {
        return "Sell in: " + days;
    }
}
