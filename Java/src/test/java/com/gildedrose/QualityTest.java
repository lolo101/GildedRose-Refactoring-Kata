package com.gildedrose;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;

class QualityTest {

    @Test
    void quality_should_not_go_below_zero() {
        Item[] items = { new Item("foo", 0, 0) };
        GildedRose app = new GildedRose(items);
        app.updateQuality();
        assertEquals(0, app.items[0].quality.value());
    }

    @Test
    void quality_should_not_go_over_fifty() {
        Item[] items = { new Item("Aged Brie", 1, 50) };
        GildedRose app = new GildedRose(items);
        app.updateQuality();
        assertEquals(50, app.items[0].quality.value());
    }

}
