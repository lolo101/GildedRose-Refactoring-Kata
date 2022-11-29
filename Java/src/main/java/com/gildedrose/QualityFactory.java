package com.gildedrose;

public class QualityFactory {
    static Quality select(Item item) {
        switch (item.name) {
            case "Sulfuras, Hand of Ragnaros":
                return new SulfurasQuality();
            case "Aged Brie":
                return new AgedBrieQuality(item);
            case "Backstage passes to a TAFKAL80ETC concert":
                return new BackstagePassesQuality(item);
            default:
                return new DefaultQuality(item);
        }
    }

    private static class SulfurasQuality extends Quality {

        private SulfurasQuality() {
            super(null);
        }

        @Override
        protected void updateSellIn() {
            // do nothing
        }

        @Override
        protected void upateQuality() {
            // do nothing
        }
    }

    private static class AgedBrieQuality extends Quality {

        private AgedBrieQuality(Item item) {
            super(item);
        }

        @Override
        protected void upateQuality() {
            if (item.quality < 50) {
                item.quality = item.quality + 1;
            }
            if (item.sellIn < 0) {
                if (item.quality < 50) {
                    item.quality = item.quality + 1;
                }
            }
        }
    }

    private static class BackstagePassesQuality extends Quality {

        private BackstagePassesQuality(Item item) {
            super(item);
        }

        @Override
        protected void upateQuality() {
            if (item.quality < 50) {
                item.quality = item.quality + 1;
                if (item.sellIn < 10) {
                    item.quality = item.quality + 1;
                }
                if (item.sellIn < 5) {
                    item.quality = item.quality + 1;
                }
            }
            if (item.sellIn <= 0) {
                item.quality = 0;
            }
        }
    }

    private static class DefaultQuality extends Quality {

        private DefaultQuality(Item item) {
            super(item);
        }

        @Override
        protected void upateQuality() {
            if (item.quality > 0) {
                item.quality = item.quality - (item.sellIn < 0 ? 2 : 1);
            }
        }
    }
}
