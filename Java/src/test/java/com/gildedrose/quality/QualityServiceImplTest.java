package com.gildedrose.quality;

import com.gildedrose.Item;
import com.gildedrose.quality.QualityService;
import com.gildedrose.quality.QualityServiceImpl;
import com.gildedrose.quality.delegates.AgedBrieQualityServiceDelegate;
import com.gildedrose.quality.delegates.BackstageTicketQualityServiceDelegate;
import com.gildedrose.quality.delegates.ConjuredQualityServiceDelegate;
import com.gildedrose.quality.delegates.QualityServiceDelegate;
import com.gildedrose.quality.delegates.SulfurasQualityServiceDelegate;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.TestInstance;

import java.util.HashMap;

import static org.junit.jupiter.api.Assertions.*;

class QualityServiceImplTest {

    private QualityService qualityService;

    @Test
    void updateQualityOfItem_onlyDefault() {
        HashMap<String, QualityServiceDelegate> delegateMap = new HashMap<>();
        qualityService = new QualityServiceImpl(delegateMap);
        Item item = new Item("foo", 9, 10);
        qualityService.updateQualityOfItem(item);
        assertEquals(9,item.quality);
        assertEquals(8,item.sellIn);
    }

    @Test
    void updateQualityOfItem_withADelegateThatNeverAges() {
        HashMap<String, QualityServiceDelegate> delegateMap = new HashMap<>();
        delegateMap.put("foo",new SulfurasQualityServiceDelegate());
        qualityService = new QualityServiceImpl(delegateMap);
        Item item = new Item("foo", 9, 10);
        qualityService.updateQualityOfItem(item);
        assertEquals(10,item.quality);
        assertEquals(9,item.sellIn);
    }
    @Test
    void updateQualityOfItem_fallBackOnDefaultDelegate() {
        HashMap<String, QualityServiceDelegate> delegateMap = new HashMap<>();
        delegateMap.put("foo",new SulfurasQualityServiceDelegate());
        qualityService = new QualityServiceImpl(delegateMap);
        Item item = new Item("notFoo", 9, 10);
        qualityService.updateQualityOfItem(item);
        assertEquals(9,item.quality);
        assertEquals(8,item.sellIn);
    }


}
