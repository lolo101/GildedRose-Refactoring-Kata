package com.gildedrose;

public class Item {

    public String name;

    public int sellIn;

    public Quality quality;

    public Item(String name, int sellIn, int quality) {
        this.name = name;
        this.sellIn = sellIn;
        this.quality = new Quality(quality);
    }

   @Override
   public String toString() {
        return this.name + ", " + this.sellIn + ", " + this.quality.value();
    }
}
