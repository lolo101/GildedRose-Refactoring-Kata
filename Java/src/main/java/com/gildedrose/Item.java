package com.gildedrose;

import java.util.HashMap;
import java.util.Map;

public class Item {

    private static final Map<String, QualityRule> qualityRules = new HashMap<>();
    static {
        qualityRules.put("Aged Brie", (sellIn, quality) -> quality.increment());
        qualityRules.put("Backstage passes to a TAFKAL80ETC concert", (sellIn, quality) -> {
            if (sellIn < 0) return new Quality(0);
            if (sellIn <= 5) return quality.increment().increment().increment();
            if (sellIn <= 10) return quality.increment().increment();
            return quality.increment();
        });
        qualityRules.put("Sulfuras, Hand of Ragnaros", (sellIn, quality) -> quality);
        qualityRules.put("Conjured Mana Cake", (sellIn, quality) -> sellIn >= 0 ? quality.decrement().decrement() : quality.decrement().decrement().decrement().decrement());
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

        QualityRule rule = qualityRules.getOrDefault(name, (sellIn, quality) -> sellIn >= 0 ? quality.decrement() : quality.decrement().decrement());
        quality = rule.updateQuality(sellIn, quality);
    }

    @Override
    public String toString() {
        return this.name + ", " + this.sellIn + ", " + this.quality.value();
    }
}
