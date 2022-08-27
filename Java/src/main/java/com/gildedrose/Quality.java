package com.gildedrose;

public class Quality {
    private static final int MIN_VALUE = 0;
    private static final int MAX_VALUE = 50;
    private final int value;

    public Quality(int value) {
        this.value = value;
    }

    public Quality increment() {
        return increment(1);
    }

    public Quality increment(int increment) {
        return new Quality(Math.min(MAX_VALUE, value + increment));
    }

    public Quality decrement() {
        return decrement(1);
    }

    public Quality decrement(int decrement) {
        return new Quality(Math.max(MIN_VALUE, value - decrement));
    }

    public int value() {
        return value;
    }
}
