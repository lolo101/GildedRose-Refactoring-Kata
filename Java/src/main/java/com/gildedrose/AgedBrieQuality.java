package com.gildedrose;

class AgedBrieQuality extends Quality {

    AgedBrieQuality(Item item) {
        super(item);
    }

    @Override
    protected void upateQuality() {
        if (item.quality < 50) {
            item.quality = item.quality + 1;
        }
        if (item.sellIn < 0) {
            if (item.quality < 50) {
                item.quality = item.quality + 1;
            }
        }
    }
}
