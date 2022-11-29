package com.gildedrose;

class BackstagePassesQuality extends Quality {

    BackstagePassesQuality(Item item) {
        super(item);
    }

    @Override
    protected void upateQuality() {
        if (item.quality < 50) {
            item.quality = item.quality + 1;
            if (item.sellIn < 10) {
                item.quality = item.quality + 1;
            }
            if (item.sellIn < 5) {
                item.quality = item.quality + 1;
            }
        }
        if (item.sellIn <= 0) {
            item.quality = 0;
        }
    }
}
