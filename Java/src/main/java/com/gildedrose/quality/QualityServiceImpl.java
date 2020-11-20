package com.gildedrose.quality;

import com.gildedrose.Item;
import com.gildedrose.quality.delegates.AgedBrieQualityServiceDelegate;
import com.gildedrose.quality.delegates.BackstageTicketQualityServiceDelegate;
import com.gildedrose.quality.delegates.QualityServiceDelegate;
import com.gildedrose.quality.delegates.SulfurasQualityServiceDelegate;

import java.util.HashMap;
import java.util.Map;

public class QualityServiceImpl implements QualityService {

    // TODO : Make the process item specific, both downgrade, aging and overdue
    // The goal will be to have specific rules for different items and make it easier to add other items in the future

    private Map<String, QualityServiceDelegate> delegateMap;
    private QualityServiceDelegate defaultDelegate = new QualityServiceDelegate();

    public QualityServiceImpl() {
        this.delegateMap = new HashMap<>();
        delegateMap.put("Backstage passes to a TAFKAL80ETC concert", new BackstageTicketQualityServiceDelegate());
        delegateMap.put("Aged Brie", new AgedBrieQualityServiceDelegate());
        delegateMap.put("Sulfuras, Hand of Ragnaros", new SulfurasQualityServiceDelegate());
    }

    public void updateQualityOfItem(Item item) {
        QualityServiceDelegate activeDelegate = defaultDelegate;
        if (delegateMap.containsKey(item.name)) {
            activeDelegate = delegateMap.get(item.name);
        }
        activeDelegate.updateQuality(item);
        activeDelegate.ageItem(item);
        if (item.sellIn < 0) {
            activeDelegate.updateQualityOfOverdueItem(item);
        }
    }

}
