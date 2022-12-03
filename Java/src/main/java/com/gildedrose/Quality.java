package com.gildedrose;

import static java.lang.Math.max;
import static java.lang.Math.min;

public abstract class Quality {

    protected final Item item;

    protected Quality(Item item) {
        this.item = item;
    }

    public final void update() {
        item.sellIn += sellInIncrement();
        int unboundedQuality = item.quality + qualityIncrement();
        item.quality = max(0, min(unboundedQuality, 50));
    }

    protected int sellInIncrement() {
        return -1;
    }

    protected abstract int qualityIncrement();
}
