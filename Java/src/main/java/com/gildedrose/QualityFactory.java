package com.gildedrose;

import java.util.HashMap;
import java.util.Map;

public class QualityFactory {

    private static final Map<String, Class<? extends Quality>> qualities = new HashMap<>();
    static {
        qualities.put("Sulfuras, Hand of Ragnaros", SulfurasQuality.class);
        qualities.put("Aged Brie", AgedBrieQuality.class);
        qualities.put("Backstage passes to a TAFKAL80ETC concert", BackstagePassesQuality.class);
    }

    static Quality select(Item item) {
        try {
            Class<? extends Quality> quality = qualities.getOrDefault(item.name, DefaultQuality.class);
            return quality.getDeclaredConstructor(Item.class).newInstance(item);
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
    }
}
