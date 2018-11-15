package com.gildedrose.items;

import java.util.Objects;

class SellIn {

    private static final int EXPIRY_THRESHOLD = 0;

    private final int days;

    private SellIn(final int days) {
        this.days = days;
    }

    public static SellIn of(final int days) {
        return new SellIn(days);
    }

    SellIn update() {
        return of(days - 1);
    }

    boolean isExpired() {
        return lessThan(EXPIRY_THRESHOLD);
    }

    boolean lessThan(final int days) {
        return this.days < days;
    }

    @Override
    public boolean equals(final Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        final SellIn sellIn = (SellIn) o;
        return days == sellIn.days;
    }

    @Override
    public int hashCode() {
        return Objects.hash(days);
    }

    @Override
    public String toString() {
        return "Sell in: " + days;
    }
}
