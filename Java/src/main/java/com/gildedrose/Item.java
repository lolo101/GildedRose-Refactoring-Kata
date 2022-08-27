package com.gildedrose;

import java.util.HashMap;
import java.util.Map;

public class Item {

    private static final Map<String, QualityRule> qualityRules = new HashMap<>();
    static {
        qualityRules.put("Aged Brie", (sellIn, quality) -> quality.increment());
        qualityRules.put("Backstage passes to a TAFKAL80ETC concert", (sellIn, quality) -> {
            if (sellIn < 0) return new Quality(0);
            if (sellIn <= 5) return quality.increment(3);
            if (sellIn <= 10) return quality.increment(2);
            return quality.increment();
        });
        qualityRules.put("Sulfuras, Hand of Ragnaros", (sellIn, quality) -> quality);
        qualityRules.put("Conjured Mana Cake", (sellIn, quality) -> quality.decrement(sellIn >= 0 ? 2 : 4));
    }

    public final String name;

    public int sellIn;

    public Quality quality;

    public Item(String name, int sellIn, int quality) {
        this.name = name;
        this.sellIn = sellIn;
        this.quality = new Quality(quality);
    }

    public void updateQuality() {
        if (!name.equals("Sulfuras, Hand of Ragnaros")) --sellIn;

        QualityRule rule = qualityRules.getOrDefault(name, (sellIn, quality) -> quality.decrement(sellIn >= 0 ? 1 : 2));
        quality = rule.updateQuality(sellIn, quality);
    }

    @Override
    public String toString() {
        return this.name + ", " + this.sellIn + ", " + this.quality.value();
    }
}
