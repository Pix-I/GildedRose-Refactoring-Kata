package com.gildedrose.quality.delegates;

import com.gildedrose.Item;

public class QualityServiceDelegate {

    public void ageItem(Item i) {
        i.sellIn = i.sellIn - 1;
    }

    public void updateQuality(Item i) {

    }

    public void updateQualityOfOverdueItem(Item i) {

    }

    protected void upgradeQuality(Item item) {
        if (item.quality < 50) {
            item.quality++;
        }
    }

    protected void downGradeQuality(Item item) {
        if (item.quality > 0) {
            item.quality--;
        }
    }

}
