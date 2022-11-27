package com.gildedrose;

class GildedRose {
    Item[] items;

    public GildedRose(Item[] items) {
        this.items = items;
    }

    public void updateQuality() {
        for (Item item : items) updateQuality(item);
    }

    private static void updateQuality(Item item) {
        QualityFactory.select(item);
    }
}
