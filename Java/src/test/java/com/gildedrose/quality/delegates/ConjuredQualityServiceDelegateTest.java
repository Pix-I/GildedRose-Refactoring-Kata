package com.gildedrose.quality.delegates;

import com.gildedrose.Item;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class ConjuredQualityServiceDelegateTest {

    private ConjuredQualityServiceDelegate qualityService = new ConjuredQualityServiceDelegate();

    @Test
    void updateQuality_worthSomething() {
        Item item = new Item("Aged Brie", 0, 4);
        qualityService.updateQuality(item);
        assertEquals(2,item.quality);
    }

    @Test
    void updateQuality_alreadyWorthless() {
        Item item = new Item("Aged Brie", 0, 0);
        qualityService.updateQuality(item);
        assertEquals(0,item.quality);
    }

    @Test
    void updateOvderdueQuality_worthSomething() {
        Item item = new Item("Aged Brie", 0, 4);
        qualityService.updateQualityOfOverdueItem(item);
        assertEquals(2,item.quality);
    }

    @Test
    void updateOvderdueQuality_alreadyWorthless() {
        Item item = new Item("Aged Brie", 0, 0);
        qualityService.updateQualityOfOverdueItem(item);
        assertEquals(0,item.quality);
    }
}
