package com.gildedrose.quality;

import com.gildedrose.Item;
import com.gildedrose.quality.delegates.SulfurasQualityServiceDelegate;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class SulfurasQualityServiceDelegateTest {

    private SulfurasQualityServiceDelegate delegate = new SulfurasQualityServiceDelegate();

    @Test
    void ageItem() {
        Item item = new Item("Sulfuras, Hand of Ragnaros", 10, 80);
        delegate.ageItem(item);
        assertEquals(10,item.sellIn);
    }

    @Test
    void updateQuality() {
        Item item = new Item("Sulfuras, Hand of Ragnaros", 10, 80);
        delegate.updateQuality(item);
        assertEquals(80,item.quality);
    }

    @Test
    void updateQualityOfOverdueItem() {
        Item item = new Item("Sulfuras, Hand of Ragnaros", 10, 80);
        delegate.updateQualityOfOverdueItem(item);
        assertEquals(80,item.quality);
    }
}
