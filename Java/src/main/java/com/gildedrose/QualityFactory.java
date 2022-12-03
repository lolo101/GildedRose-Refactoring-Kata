package com.gildedrose;

public class QualityFactory {
    static Quality select(Item item) {
        switch (item.name) {
            case "Sulfuras, Hand of Ragnaros":
                return new SulfurasQuality(item);
            case "Aged Brie":
                return new AgedBrieQuality(item);
            case "Backstage passes to a TAFKAL80ETC concert":
                return new BackstagePassesQuality(item);
            default:
                return new DefaultQuality(item);
        }
    }
}
