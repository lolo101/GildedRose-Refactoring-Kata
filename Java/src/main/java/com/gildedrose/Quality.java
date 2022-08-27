package com.gildedrose;

public class Quality {
    private static final int MIN_VALUE = 0;
    private static final int MAX_VALUE = 50;
    private final int value;

    public Quality(int value) {
        this.value = value;
    }

    public Quality increment() {
        return (value < MAX_VALUE) ? new Quality(value + 1) : this;
    }

    public Quality decrement() {
        return (value > MIN_VALUE) ? new Quality(value - 1) : this;
    }

    public int value() {
        return value;
    }
}
