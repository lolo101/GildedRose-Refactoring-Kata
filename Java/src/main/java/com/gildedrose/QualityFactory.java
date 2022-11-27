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

    private static class SulfurasQuality implements Quality {
        @Override
        public void update() {
            // do nothing
        }
    }

    private static class AgedBrieQuality implements Quality {

        private final Item item;

        private AgedBrieQuality(Item item) {
            this.item = item;
        }

        @Override
        public void update() {
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
    }

    private static class BackstagePassesQuality implements Quality {

        private final Item item;

        private BackstagePassesQuality(Item item) {
            this.item = item;
        }

        @Override
        public void update() {
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
    }

    private static class DefaultQuality implements Quality {

        private final Item item;

        private DefaultQuality(Item item) {
            this.item = item;
        }

        @Override
        public void update() {
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
}
