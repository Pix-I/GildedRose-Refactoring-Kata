package com.gildedrose.quality.delegates;

import com.gildedrose.Item;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class AgedBrieQualityServiceDelegateTest {

    private AgedBrieQualityServiceDelegate delegate = new AgedBrieQualityServiceDelegate();

    @Test
    void updateQuality_lessThan5Days() {
        Item agedBrie = new Item("Aged Brie", 2, 0);
        delegate.updateQuality(agedBrie);
        assertEquals(3,agedBrie.quality);
    }
    @Test
    void updateQuality_lessThan10Days() {
        Item agedBrie = new Item("Aged Brie", 10, 0);
        delegate.updateQuality(agedBrie);
        assertEquals(2,agedBrie.quality);
    }
    @Test
    void updateQuality_lessThan15Days() {
        Item agedBrie = new Item("Aged Brie", 15, 0);
        delegate.updateQuality(agedBrie);
        assertEquals(1,agedBrie.quality);
    }

    // This still seems weird, the original code wanted to upgrade the quality by 1
    @Test
    void updateQualityOfOverdueItem() {
        Item agedBrie = new Item("Aged Brie", 0, 0);
        delegate.updateQualityOfOverdueItem(agedBrie);
        assertEquals(1,agedBrie.quality);
    }

    // This still seems weird, the original code wanted to upgrade the quality by 1
    @Test
    void updateQualityOfOverdueItem_maxed() {
        Item agedBrie = new Item("Aged Brie", 0, 50);
        delegate.updateQualityOfOverdueItem(agedBrie);
        assertEquals(50,agedBrie.quality);
    }

}
