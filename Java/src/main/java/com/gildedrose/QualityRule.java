package com.gildedrose;

@FunctionalInterface
public interface QualityRule {
    Quality updateQuality(int sellIn, Quality quality);
}
