package com.gildedrose.items;

import java.util.Objects;

public class Quality {

    private static final int MAXIMUM_QUALITY = 50;

    private final int value;

    private Quality(final int value) {
        this.value = value;
    }

    public static Quality of(final int value) {
        return new Quality(value);
    }

    Quality increase() {
        if (value == MAXIMUM_QUALITY)
            return this;

        return of(value + 1);
    }

    Quality decrease() {
        throw new UnsupportedOperationException();
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
