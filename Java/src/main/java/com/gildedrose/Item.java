package com.gildedrose;

// public fields are evil..
public class Item {

    public String name;

    //  Denotes the number of days we have to sell the item
    public int sellIn;

    //  Denotes how valuable the item is
    public int quality;

    public Item(String name, int sellIn, int quality) {
        this.name = name;
        this.sellIn = sellIn;
        this.quality = quality;
    }


   @Override
   public String toString() {
        return this.name + ", " + this.sellIn + ", " + this.quality;
    }
}
