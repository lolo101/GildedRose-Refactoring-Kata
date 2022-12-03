package com.gildedrose;

class DefaultQuality extends Quality {

    DefaultQuality(Item item) {
        super(item);
    }

    @Override
    protected int qualityIncrement() {
        return item.sellIn < 0 ? -2 : -1;
    }
}
