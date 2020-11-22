package com.gildedrose;

import com.gildedrose.quality.QualityService;
import com.gildedrose.quality.QualityServiceImpl;
import com.gildedrose.quality.delegates.AgedBrieQualityServiceDelegate;
import com.gildedrose.quality.delegates.BackstageTicketQualityServiceDelegate;
import com.gildedrose.quality.delegates.ConjuredQualityServiceDelegate;
import com.gildedrose.quality.delegates.QualityServiceDelegate;
import com.gildedrose.quality.delegates.SulfurasQualityServiceDelegate;

import java.util.HashMap;

class GildedRose {
    private final Item[] items;

    private final QualityService qualityService;

    public GildedRose(Item[] items){
        this.items = items;
        HashMap<String, QualityServiceDelegate> delegateMap = new HashMap<>();
        delegateMap.put("Backstage passes to a TAFKAL80ETC concert", new BackstageTicketQualityServiceDelegate());
        delegateMap.put("Aged Brie", new AgedBrieQualityServiceDelegate());
        delegateMap.put("Conjured Mana Cake", new ConjuredQualityServiceDelegate());
        delegateMap.put("Sulfuras, Hand of Ragnaros", new SulfurasQualityServiceDelegate());
        qualityService = new QualityServiceImpl(delegateMap);
    }



    public Item[] getItems() {
        return items;
    }

    public void updateQuality() {
        for (Item item : items) {
            qualityService.updateQualityOfItem(item);
        }
    }

}
