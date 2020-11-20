package com.gildedrose.quality.delegates;

import com.gildedrose.Item;

public class AgedBrieQualityServiceDelegate extends QualityServiceDelegate {

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
        upgradeQuality(i);
    }
}
