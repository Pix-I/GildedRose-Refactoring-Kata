package com.gildedrose.quality;

import com.gildedrose.Item;
import com.gildedrose.quality.delegates.AgedBrieQualityServiceDelegate;
import com.gildedrose.quality.delegates.BackstageTicketQualityServiceDelegate;
import com.gildedrose.quality.delegates.ConjuredQualityServiceDelegate;
import com.gildedrose.quality.delegates.QualityServiceDelegate;
import com.gildedrose.quality.delegates.SulfurasQualityServiceDelegate;

import java.util.HashMap;
import java.util.Map;

public class QualityServiceImpl implements QualityService {

    // The goal will be to have specific rules for different items and make it easier to add other items in the future

    private Map<String, QualityServiceDelegate> delegateMap;
    private QualityServiceDelegate defaultDelegate = new QualityServiceDelegate();

    // Another way to do this would be a switch statement or an if-else condition
    // I choose this way because it's actually a bit less verbose and faster to write
    // The next step would be to add a "configuration" class that adds the delegates dynamically.
    //
    public QualityServiceImpl(Map<String,QualityServiceDelegate> delegateMap) {
        this.delegateMap = delegateMap;
    }

    public void updateQualityOfItem(Item item) {
        QualityServiceDelegate activeDelegate = delegateMap.getOrDefault(item.name, defaultDelegate);
        activeDelegate.updateQuality(item);
        activeDelegate.ageItem(item);
        if (item.sellIn < 0) {
            activeDelegate.updateQualityOfOverdueItem(item);
        }
    }

}
