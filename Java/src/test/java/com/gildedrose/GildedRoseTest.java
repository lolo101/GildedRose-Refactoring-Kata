package com.gildedrose;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

class GildedRoseTest {

    @Test
    void items_should_decreare_in_quality() {
        Item[] items = { new Item("foo", 1, 1) };
        GildedRose app = new GildedRose(items);
        app.updateQuality();
        assertEquals(0, app.items[0].quality);
    }

    @Test
    void items_should_get_closer_to_sell_date() {
        Item[] items = { new Item("foo", 1, 1) };
        GildedRose app = new GildedRose(items);
        app.updateQuality();
        assertEquals(0, app.items[0].sellIn);
    }

    @Test
    void quality_should_not_go_below_zero() {
        Item[] items = { new Item("foo", 0, 0) };
        GildedRose app = new GildedRose(items);
        app.updateQuality();
        assertEquals(0, app.items[0].quality);
    }

    @Test
    void quality_should_decrease_faster_past_sell_date() {
        Item[] items = { new Item("foo", 0, 2) };
        GildedRose app = new GildedRose(items);
        app.updateQuality();
        assertEquals(0, app.items[0].quality);
    }

    @Test
    void Aged_Bree_should_increase_in_quality() {
        Item[] items = { new Item("Aged Brie", 1, 0) };
        GildedRose app = new GildedRose(items);
        app.updateQuality();
        assertEquals(1, app.items[0].quality);
    }

    @Test
    void quality_should_not_go_over_fifty() {
        Item[] items = { new Item("Aged Brie", 1, 50) };
        GildedRose app = new GildedRose(items);
        app.updateQuality();
        assertEquals(50, app.items[0].quality);
    }

    @Test
    void Sulfuras_should_have_constant_quality() {
        Item[] items = { new Item("Sulfuras, Hand of Ragnaros", 1, 10) };
        GildedRose app = new GildedRose(items);
        app.updateQuality();
        assertEquals(10, app.items[0].quality);
    }

    @Test
    void Sulfuras_should_have_constant_sell_date() {
        Item[] items = { new Item("Sulfuras, Hand of Ragnaros", 1, 10) };
        GildedRose app = new GildedRose(items);
        app.updateQuality();
        assertEquals(1, app.items[0].sellIn);
    }

    @Test
    void Backstage_passes_should_increase_in_quality() {
        Item[] items = { new Item("Backstage passes to a TAFKAL80ETC concert", 100, 0) };
        GildedRose app = new GildedRose(items);
        app.updateQuality();
        assertEquals(1, app.items[0].quality);
    }

    @Test
    void Backstage_passes_should_increase_by_two_in_quality_when_sell_date_is_ten_or_below() {
        Item[] items = { new Item("Backstage passes to a TAFKAL80ETC concert", 10, 0) };
        GildedRose app = new GildedRose(items);
        app.updateQuality();
        assertEquals(2, app.items[0].quality);
    }

    @Test
    void Backstage_passes_should_increase_by_three_in_quality_when_sell_date_is_five_or_below() {
        Item[] items = { new Item("Backstage passes to a TAFKAL80ETC concert", 5, 0) };
        GildedRose app = new GildedRose(items);
        app.updateQuality();
        assertEquals(3, app.items[0].quality);
    }

    @Test
    void Backstage_passes_should_have_zero_quality_when_past_sell_date() {
        Item[] items = { new Item("Backstage passes to a TAFKAL80ETC concert", 0, 50) };
        GildedRose app = new GildedRose(items);
        app.updateQuality();
        assertEquals(0, app.items[0].quality);
    }

}
