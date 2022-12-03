package com.gildedrose;

class AgedBrieQuality extends Quality {

    AgedBrieQuality(Item item) {
        super(item);
    }

    @Override
    protected int qualityIncrement() {
        return item.sellIn < 0 ? 2 : 1;
    }
}
