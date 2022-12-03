package com.gildedrose;

public class ConjuredQuality extends Quality {
    ConjuredQuality(Item item) {
        super(item);
    }

    @Override
    protected int qualityIncrement() {
        return item.sellIn < 0 ? -4 : -2;
    }
}
