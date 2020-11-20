package com.gildedrose.quality.delegates;

import com.gildedrose.Item;

public class BackstageTicketQualityServiceDelegate extends QualityServiceDelegate {


    @Override
    public void updateQuality(Item item) {
        upgradeQuality(item);
        if (item.sellIn < 11) {
            upgradeQuality(item);
        }
        if (item.sellIn < 6) {
            upgradeQuality(item);
        }
    }

    @Override
    public void updateQualityOfOverdueItem(Item i) {
        i.quality = 0;
    }
}
