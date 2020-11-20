package com.gildedrose.quality;

import com.gildedrose.Item;
import com.gildedrose.quality.QualityService;
import com.gildedrose.quality.QualityServiceImpl;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class QualityServiceImplTest {

    private QualityService qualityService = new QualityServiceImpl();

    @Test
    void updateQualityOfItem_neverNegative() {
        Item item = new Item("foo", 0, 0);
        qualityService.updateQualityOfItem(item);
        assertEquals(0,item.quality);
    }

    @Test
    void updateQualityOfItem_normalTempo() {
        Item item = new Item("foo", 10, 10);
        qualityService.updateQualityOfItem(item);
        assertEquals(9,item.quality);
    }

    @Test
    void updateQualityOfItem_pastDueDateTempo() {
        Item item = new Item("foo", 0, 10);
        qualityService.updateQualityOfItem(item);
        assertEquals(8,item.quality);
    }

    // Does it make sense for agedBrie to get quality twice as fast once it's past the sellIn date?
    @Test
    void updateQualityOfItem_agedBrie() {
        Item item = new Item("Aged Brie", 0, 10);
        qualityService.updateQualityOfItem(item);
        assertEquals(12,item.quality);
    }

    @Test
    void updateQualityOfItem_agedBrie_normal() {
        Item item = new Item("Aged Brie", 10, 10);
        qualityService.updateQualityOfItem(item);
        assertEquals(11,item.quality);
    }

    @Test
    void updateQualityOfItem_agedBrie_maxedOut() {
        Item item = new Item("Aged Brie", 0, 49);
        qualityService.updateQualityOfItem(item);
        assertEquals(50,item.quality);
    }
    @Test
    void updateQualityOfItem_sulfuras() {
        Item item = new Item("Sulfuras, Hand of Ragnaros", 0, 80);
        qualityService.updateQualityOfItem(item);
        assertEquals(80,item.quality);
    }
}
