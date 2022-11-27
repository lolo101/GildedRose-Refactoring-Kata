package com.gildedrose;

public class QualityFactory {
    static void select(Item item) {
        switch (item.name) {
            case "Sulfuras, Hand of Ragnaros":
                break;
            case "Aged Brie":
                handleAgedBrie(item);
                break;
            case "Backstage passes to a TAFKAL80ETC concert":
                handleBackstagePasses(item);
                break;
            default:
                handleDefault(item);
                break;
        }
    }

    private static void handleAgedBrie(Item item) {
        if (item.quality < 50) {
            item.quality = item.quality + 1;
        }
        item.sellIn = item.sellIn - 1;
        if (item.sellIn < 0) {
            if (item.quality < 50) {
                item.quality = item.quality + 1;
            }
        }
    }

    private static void handleBackstagePasses(Item item) {
        if (item.quality < 50) {
            item.quality = item.quality + 1;
        }

        if (item.sellIn < 11) {
            item.quality = item.quality + 1;
        }

        if (item.sellIn < 6) {
            item.quality = item.quality + 1;
        }
        item.sellIn = item.sellIn - 1;
        if (item.sellIn < 0) {
            item.quality = 0;
        }
    }

    private static void handleDefault(Item item) {
        if (item.quality > 0) {
            item.quality = item.quality - 1;
        }
        item.sellIn = item.sellIn - 1;
        if (item.sellIn < 0) {
            if (item.quality > 0) {
                item.quality = item.quality - 1;
            }
        }
    }
}
