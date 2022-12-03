package com.gildedrose;

class BackstagePassesQuality extends Quality {

    BackstagePassesQuality(Item item) {
        super(item);
    }

    @Override
    protected int qualityIncrement() {
        if (item.sellIn <= 0) {
            return Integer.MIN_VALUE;
        }
        if (item.sellIn < 5) {
            return 3;
        }
        if (item.sellIn < 10) {
            return 2;
        }
        return 1;
    }
}
