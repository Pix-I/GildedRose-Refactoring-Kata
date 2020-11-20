package com.gildedrose.quality;

import com.gildedrose.Item;
import com.gildedrose.quality.delegates.QualityServiceDelegate;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

class QualityServiceDelegateTest {


    private QualityServiceDelegate qualityService = new QualityServiceDelegate();

    @Test
    void ageItem() {
    }

    @Test
    void updateQuality_worthSomething() {
        Item item = new Item("Aged Brie", 0, 4);
        qualityService.updateQuality(item);
        assertEquals(3,item.quality);
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
        assertEquals(3,item.quality);
    }

    @Test
    void updateOvderdueQuality_alreadyWorthless() {
        Item item = new Item("Aged Brie", 0, 0);
        qualityService.updateQualityOfOverdueItem(item);
        assertEquals(0,item.quality);
    }
}
