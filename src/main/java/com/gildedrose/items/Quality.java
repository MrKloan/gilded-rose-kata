package com.gildedrose.items;

import java.util.Objects;

public class Quality {

    private static final int MAXIMUM_QUALITY = 50;
    private static final int MINIMUM_QUALITY = 0;

    private final int value;

    private Quality(final int value) {
        this.value = value;
    }

    public static Quality of(final int value) {
        return new Quality(value);
    }

    static Quality none() {
        return of(0);
    }

    Quality increase() {
        if (value == MAXIMUM_QUALITY)
            return this;

        return of(value + 1);
    }

    Quality decrease() {
        if (value == MINIMUM_QUALITY)
            return this;

        return of(value - 1);
    }

    @Override
    public boolean equals(final Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        final Quality quality = (Quality) o;
        return value == quality.value;
    }

    @Override
    public int hashCode() {
        return Objects.hash(value);
    }

    @Override
    public String toString() {
        return "Quality: " + value;
    }
}
