package com.gildedrose.items;

class SellIn {

    private static final int EXPIRY_THRESHOLD = 0;

    private final int days;

    private SellIn(final int days) {
        this.days = days;
    }

    public static SellIn of(final int days) {
        return new SellIn(days);
    }

    boolean isExpired() {
        return lessThan(EXPIRY_THRESHOLD);
    }

    boolean lessThan(final int days) {
        return this.days < days;
    }

    @Override
    public String toString() {
        return "Sell in: " + days;
    }
}
