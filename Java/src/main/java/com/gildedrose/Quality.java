package com.gildedrose;

public class Quality {
    private static final int MIN_VALUE = 0;
    private static final int MAX_VALUE = 50;
    private int value;

    public Quality(int value) {
        this.value = value;
    }

    public void increment() {
        if(value < MAX_VALUE) ++value;
    }

    public void decrement() {
        if(value > MIN_VALUE) --value;
    }

    public int value() {
        return value;
    }
}
