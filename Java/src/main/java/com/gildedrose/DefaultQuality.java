package com.gildedrose;

class DefaultQuality extends Quality {

    DefaultQuality(Item item) {
        super(item);
    }

    @Override
    protected void upateQuality() {
        if (item.quality > 0) {
            item.quality = item.quality - (item.sellIn < 0 ? 2 : 1);
        }
    }
}
