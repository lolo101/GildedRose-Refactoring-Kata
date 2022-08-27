package com.gildedrose;

public class Item {

    public String name;

    public int sellIn;

    public Quality quality;

    public Item(String name, int sellIn, int quality) {
        this.name = name;
        this.sellIn = sellIn;
        this.quality = new Quality(quality);
    }

    public void updateQuality() {
        if (!name.equals("Aged Brie")
            && !name.equals("Backstage passes to a TAFKAL80ETC concert")) {
            if (!name.equals("Sulfuras, Hand of Ragnaros")) {
                quality.decrement();
            }
        } else {
            quality.increment();

            if (name.equals("Backstage passes to a TAFKAL80ETC concert")) {
                if (sellIn < 11) {
                    quality.increment();
                }

                if (sellIn < 6) {
                    quality.increment();
                }
            }
        }

        if (!name.equals("Sulfuras, Hand of Ragnaros")) {
            sellIn = sellIn - 1;
        }

        if (sellIn < 0) {
            if (!name.equals("Aged Brie")) {
                if (!name.equals("Backstage passes to a TAFKAL80ETC concert")) {
                    if (!name.equals("Sulfuras, Hand of Ragnaros")) {
                        quality.decrement();
                    }
                } else {
                    quality = new Quality(0);
                }
            } else {
                quality.increment();
            }
        }
    }

    @Override
    public String toString() {
        return this.name + ", " + this.sellIn + ", " + this.quality.value();
    }
}
