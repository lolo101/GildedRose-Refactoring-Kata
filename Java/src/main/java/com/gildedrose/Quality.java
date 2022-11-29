package com.gildedrose;

public abstract class Quality {

    protected final Item item;

    protected Quality(Item item) {
        this.item = item;
    }

    public final void update() {
        updateSellIn();
        upateQuality();
    }

    protected void updateSellIn() {
        item.sellIn = item.sellIn - 1;
    }

    protected abstract void upateQuality();
}
