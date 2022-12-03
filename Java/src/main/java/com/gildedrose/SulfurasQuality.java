package com.gildedrose;

class SulfurasQuality extends Quality {

    SulfurasQuality(Item item) {
        super(item);
    }

    @Override
    protected int sellInIncrement() {
        return 0;
    }

    @Override
    protected int qualityIncrement() {
        return 0;
    }
}
