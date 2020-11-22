package com.gildedrose;

import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.TestInstance;

import static org.junit.jupiter.api.Assertions.assertEquals;

@TestInstance(value = TestInstance.Lifecycle.PER_CLASS)
class GildedRoseTestIT {

    private Item[] items;

    @BeforeEach
    public void setup() {
        items = new Item[]{
                new Item("+5 Dexterity Vest", 10, 20), //
                new Item("Aged Brie", 2, 0), //
                new Item("Elixir of the Mongoose", 5, 7), //
                new Item("Sulfuras, Hand of Ragnaros", 0, 80), //
                new Item("Sulfuras, Hand of Ragnaros", -1, 80),
                new Item("Backstage passes to a TAFKAL80ETC concert", 15, 20),
                new Item("Backstage passes to a TAFKAL80ETC concert", 10, 49),
                new Item("Backstage passes to a TAFKAL80ETC concert", 5, 49),
                // this conjured item does not work properly yet
                new Item("Conjured Mana Cake", 3, 6)};
    }

    @Test
    void gildedRose_testQualityModificationRules() {
        GildedRose app = new GildedRose(items);
        app.updateQuality();
        assertEquals(19,  app.getItems()[0].quality);
        assertEquals(3,  app.getItems()[1].quality);
        assertEquals(6,  app.getItems()[2].quality);
        assertEquals(80,  app.getItems()[3].quality);
        assertEquals(80, app.getItems()[4].quality);
        assertEquals(21, app.getItems()[5].quality);
        assertEquals(50,  app.getItems()[6].quality);
        assertEquals(50,  app.getItems()[7].quality);
        assertEquals(4,  app.getItems()[8].quality);
    }

    @Test
    void gildedRose_testSellinModificationRules() {
        GildedRose app = new GildedRose(items);
        app.updateQuality();
        assertEquals(9, app.getItems()[0].sellIn);
        assertEquals(1, app.getItems()[1].sellIn);
        assertEquals(4, app.getItems()[2].sellIn);
        assertEquals(0, app.getItems()[3].sellIn);
        assertEquals(-1, app.getItems()[4].sellIn);
        assertEquals(14, app.getItems()[5].sellIn);
        assertEquals(9, app.getItems()[6].sellIn);
        assertEquals(4, app.getItems()[7].sellIn);
        assertEquals(2, app.getItems()[8].sellIn);
    }


}
